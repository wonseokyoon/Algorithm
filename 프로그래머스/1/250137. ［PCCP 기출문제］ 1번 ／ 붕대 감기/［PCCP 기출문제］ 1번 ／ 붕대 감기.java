class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int limit=attacks[attacks.length-1][0]+1;   // 12
        int[] healths=new int[limit];
        int t=bandage[0];   // 붕대 감기 시간
        int x=bandage[1];   // 초당 회복량
        int y=bandage[2];   // 추가 회복량
        int seq=0;          // 붕대 연속 감기 시간
        healths[0]=health;
        int i=1;
        for(int j=0;j<attacks.length;j++){
            int time=attacks[j][0];     // 공격 시점
            int damage=attacks[j][1];   // 데미지
            while(i<limit){
                if(i==time){    // 쳐맞으면
                    seq=0;  // 붕대 초기화
                    healths[i]=healths[i-1]-damage;     // 피깎고
                    if(healths[i]<=0){   // 뒤짐
                        return -1;
                    }
                    i++;
                    break;
                }else{
                    seq++;
                    healths[i]=healths[i-1]+x;  // 회복
                    if(seq==t){     // 추가회복
                        healths[i]=healths[i]+y;
                        seq=0;  // 초기화
                    }
                    if(healths[i]>health){
                        healths[i]=health;
                    }

                    i++;
                }
            }
        }
        return healths[limit-1];

//        int answer = 0;
//        return answer;
    }
}