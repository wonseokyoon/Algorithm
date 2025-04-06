import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int[] num = new int[100];
        for(int a:arr){
            Map<Integer,Integer> map = new HashMap<>();
            int i=2;
            while(a>1) {
                if (a % i == 0) {
                    a /= i;
                    map.put(i, map.getOrDefault(i, 0) + 1);
                } else {
                    i++;
                }
            }
            for(Integer key:map.keySet()){
                if(num[key] < map.get(key) ){
                    num[key] = map.get(key);
                }
            }
        }
        int ans = 1;
        for(int i =0 ;i<100;i++){
            if(num[i]>0){
                for(int j=0;j<num[i];j++){
                    ans *= i;
                }
            }
        }

        return ans;
    }
}