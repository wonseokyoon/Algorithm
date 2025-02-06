import java.util.*;

class Solution {
        public int[] solution(String today, String[] terms, String[] privacies) {
        String[] Params=today.split("\\.");
        int todayYear=Integer.parseInt(Params[0]);   // 년
        int todayMonth=Integer.parseInt(Params[1]);  // 월
        int todayDay=Integer.parseInt(Params[2]);    // 일
        System.out.println(todayYear+" "+todayMonth+" "+todayDay);

        ArrayList<Integer> result=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();

        for(int i=0;i< terms.length;i++){
            // A 6, B 12, C 3
            map.put(terms[i].split(" ")[0], Integer.valueOf(terms[i].split(" ")[1]));
            System.out.println(map);
        }

        for(int i=0;i< privacies.length;i++) {
            String days = privacies[i].split(" ")[0];
            String type = privacies[i].split(" ")[1];
            int year = Integer.parseInt(days.split("\\.")[0]);   //2021
            int month = Integer.parseInt(days.split("\\.")[1]);  //05
            int day = Integer.parseInt(days.split("\\.")[2]) - 1;    //02

            // 더함
            month+=map.get(type);

            if(day==0){
                day+=28;
                month--;
                if(month==0){
                    year--;
                    month+=12;
                }
            }
            
            // 연도 넘어가는거 처리
            while(month>12){
                month-=12;
                year++;
            }
            
            System.out.println(i+1+" "+year+" "+month+" "+day);
            if (year < todayYear) {
                result.add(i + 1);
            } else if (year == todayYear) {
                if (month < todayMonth) {
                    result.add(i + 1);
                } else if (month == todayMonth) {
                    if (day < todayDay) {
                        result.add(i + 1);
                    }
                }
            }

        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}