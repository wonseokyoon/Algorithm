import java.util.Arrays;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int cnt= schedules.length;
        for(int i=0;i<schedules.length;i++){
            int day=startday;
            int y=cal(schedules[i]+10);
            for(int j=0;j<7;j++){
                if(day % 7==0 || day % 7==6){
                    day++;
                    continue;
                } else {
                    // 지각
                    int x=cal(timelogs[i][j]);
                    if(x-y > 0){
                        cnt--;
                        break;
                    }
                }
                day++;
            }

        }

        return cnt;
    }

    private int cal(int time) {
        int hour= time / 100;
        int minute= time % 100;
        if(minute>=60){
            hour++;
            minute-=60;
        }
        return hour*100+minute;
    }
}