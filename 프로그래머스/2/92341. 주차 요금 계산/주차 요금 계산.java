import java.util.*;
class Solution {
public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0];     // 기본 시간
        int baseRate = fees[1];     // 기본 요금
        int unitTime = fees[2];     // 단위 시간
        int unitRate = fees[3];     // 단위 요금

        // 주차 시간 기록 Map
        Map<String,Integer> durationMap = new HashMap<>();
        // IN,OUT 체크 Map
        Map<String,Integer> inOutMap = new HashMap<>();
        // 요금 기록 Map
        Map<Integer,Integer> rateMap = new HashMap<>();

        for(int i = 0; i < records.length; i++){
            String[] params = records[i].split(" ");
            String timeStr = params[0];
            String carNum = params[1];
            String type = params[2];

            String[] times = timeStr.split(":");
            int hour = Integer.parseInt(times[0]);
            int min = Integer.parseInt(times[1]);

            int time = hour * 60 + min;     // 분으로 나타낸 시간
            switch (type){
                // 총 주차 시간 = Out 시간 - In 시간
                case "IN":
                    // 들어오는 시간 입력
                    inOutMap.put(carNum,inOutMap.getOrDefault(carNum,0)+1);
                    durationMap.put(carNum,durationMap.getOrDefault(carNum,0) - time);
                    break;

                case "OUT":
                    // OUT 시간 - IN 시간
                    inOutMap.put(carNum,inOutMap.get(carNum)-1);
                    durationMap.put(carNum,durationMap.get(carNum) + time);
            }
        }


        // 출차 체크
        for(Map.Entry<String,Integer> entry : inOutMap.entrySet()){
            // In만 있고 Out은 없는 경우
            if(entry.getValue() == 1){
                // 1439= 23시59분
                durationMap.put(entry.getKey(), 1439 + durationMap.get(entry.getKey()));
            }
        }

        for(Map.Entry<String,Integer> entry : durationMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        for(Map.Entry<String,Integer> entry : durationMap.entrySet()){
            // 기본 시간 이하로 주차한 경우
            if(entry.getValue() <= baseTime){
                rateMap.put(Integer.valueOf(entry.getKey()),baseRate);
                continue;
            }

            // 총 요금 = 기본 요금 + (주차시간 - 기본시간)/단위시간 * 단위요금
            int total = (int) (baseRate + (Math.ceil((double) (entry.getValue() - baseTime) / unitTime)) * unitRate);
            rateMap.put(Integer.valueOf(entry.getKey()),total);
        }

        // 정렬
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(rateMap.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getKey));

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i).getValue();
        }

        return answer;
    }
}