class Solution {
    public String solution(int a, int b) {
        // 5월 24일:화요일, 1월 1일은 금요일
        // 0: 금요일 ~ 6: 목요일
        String[] days = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int cnt=0;
        for(int i=0;i<a;i++){
            if(i==0){
                continue;
            }
            if(i==2){
                //29일인 달
              cnt+=29;
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                //30일인 달
                cnt+=30;
            } else {
                // 31인 달
                cnt+=31;
            }
        }
        cnt+=b;
        return days[cnt%7];
    }
}