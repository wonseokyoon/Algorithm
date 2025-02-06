import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] todayParts = today.split("\\.");
        int todayYear = Integer.parseInt(todayParts[0]);
        int todayMonth = Integer.parseInt(todayParts[1]);
        int todayDay = Integer.parseInt(todayParts[2]);

        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        // 약관 종류와 유효기간을 저장
        for (String term : terms) {
            String[] parts = term.split(" ");
            map.put(parts[0], Integer.parseInt(parts[1]));
        }

        // 개인정보 정보를 확인
        for (int i = 0; i < privacies.length; i++) {
            String[] privacyParts = privacies[i].split(" ");
            String[] dateParts = privacyParts[0].split("\\.");

            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int day = Integer.parseInt(dateParts[2]);

            String type = privacyParts[1];
            int validMonths = map.get(type);

            // 유효기간 후의 날짜 계산
            month += validMonths;

            // 년도 넘어가는 처리
            while (month > 12) {
                month -= 12;
                year++;
            }

            // 당일과 비교
            if (year < todayYear || 
                (year == todayYear && (month < todayMonth || 
                (month == todayMonth && day <= todayDay)))) {
                result.add(i + 1); // 개인정보 번호는 1부터 시작
            }
        }

        // 결과를 배열로 변환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}