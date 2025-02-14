import java.util.Arrays;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {


        int monday=(8-startday)%7;  // 월요일 인덱스 번호
        int[][] logs=new int[schedules.length][7];
        for(int i=0;i<timelogs.length;i++){
            int[] log=new int[7];
            for(int j=0;j<7;j++){ // 7회 반복
                log[j]=timelogs[i][monday++];
                if(monday==7) monday=0; // 범위 조절
            }
            System.out.println(Arrays.toString(log));
            logs[i]=log;
        }

        int cnt=schedules.length;   // 총 인원
        for(int i=0;i<logs.length;i++){
            int lhour=schedules[i]/100;   // 시
            int lmin=schedules[i]%100 + 10;   // 분
            if(lmin>=60){
                lhour++;
                lmin-=60;
            }
            for (int j=0;j<5;j++){
                int hour=logs[i][j]/100;
                int min=logs[i][j]%100;
                // 늦었으면
                if(checkToLate(hour,min,lhour,lmin)){
                    cnt--;
                    break;
                }
            }
        }

        return cnt;
    }

    // 늦으면 참
    private boolean checkToLate(int hour, int min, int lhour, int lmin) {
        if(hour>lhour) return true;
        if(hour==lhour){
            if(min>lmin) return true;
        }
        return false;
    }
}