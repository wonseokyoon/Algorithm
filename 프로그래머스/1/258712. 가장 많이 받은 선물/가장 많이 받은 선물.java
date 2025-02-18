import java.util.*;
class Solution {
        public int solution(String[] friends, String[] gifts) {
        Map<String,Integer> map=new HashMap<>();    // 이름:번호
        for(int i=0;i<friends.length;i++){
            map.put(friends[i],i);
        }

        int[] scores=new int[friends.length];   // 선물 지수
        int[][] exchanges=new int[friends.length][friends.length];  // 교환 테이블

        for(int i=0;i<gifts.length;i++){
            String sender=gifts[i].split(" ")[0];   // 준 사람
            String receiver=gifts[i].split(" ")[1]; // 받은 사람

            scores[map.get(sender)]++;
            scores[map.get(receiver)]--;
            exchanges[map.get(sender)][map.get(receiver)]++;
        }

        int ans=0;
        for(int i=0;i<friends.length;i++){
            int cnt=0;
            for(int j=0;j<friends.length;j++){
                if(i==j) continue;
                if(exchanges[i][j]>exchanges[j][i]){
                    cnt++;
                } else if (exchanges[i][j]==exchanges[j][i] && scores[i] > scores[j]) {
                    cnt++;
                }
            }
            ans=Math.max(ans,cnt);
        }
        return ans;

    }
}