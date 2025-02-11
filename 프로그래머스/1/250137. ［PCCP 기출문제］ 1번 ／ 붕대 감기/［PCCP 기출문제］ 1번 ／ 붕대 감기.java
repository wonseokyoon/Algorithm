class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int now=health; // 현재 체력
        int time=bandage[0];    // 붕대감기 시간
        int dh=bandage[1];      // 초당 회복량
        int ph=bandage[2];      // 추가 회복량
        int std=0;  // 마지막으로 공격 당한 시간
        int interval=0;     // 시간 간격

        for(int[] atk:attacks){
            interval=atk[0]-std-1;    // 시간 간격
            std=atk[0];    // 공격 시간 업데이트
            if(interval>=time){
                now += interval * dh;   // 회복
                int cnt=interval/time;      // 추가회복을 몇 번 할지
                now += ph * cnt;          // 추가 회복
            }else{
                now+=interval * dh;     // 회복
            }
            now = Math.min(now,health);     // 최대 체력 조절

            now-= atk[1];
            if(now<=0){
                return -1;
            }
        }

        return now;
    }
}