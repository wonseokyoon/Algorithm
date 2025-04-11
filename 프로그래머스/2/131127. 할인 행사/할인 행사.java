import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {

        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<want.length;i++){
            map.put(want[i],map.getOrDefault(want[i],0)+number[i]);
        }
        int ans = 0;
        for(int start=0; start <= discount.length-10; start++){
            // 임시 맵
            Map<String,Integer> temp = new HashMap<>(map);
            int i;
            for(i = 0; i < 10; i++){
                int index = i + start;
                temp.put(discount[index],temp.getOrDefault(discount[index],0)-1);
                // 할인 품목중에 살게 없거나, 마지막 인덱스에 도착했을 경우
                if(temp.get(discount[index])<0){
                    break;
                }
            }

            // 10일 연속 할인 상품 다 산 경우
            if(i==10) ans++;
        }
        return ans;
    }

}