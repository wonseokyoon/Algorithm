import java.util.*;

class Solution {
    static HashMap<String, Integer> wishList;
    static HashMap<String, Integer> map;
    public int solution(String[] want, int[] number, String[] discount) {
        wishList = new HashMap<>();
        map = new HashMap<>();

        for(int i=0; i<want.length; i++){
            wishList.put(want[i], number[i]);
        }

        for(int i=0; i<10; i++){
            if(map.containsKey(discount[i])){
                map.put(discount[i], map.get(discount[i])+1);
            } else {
                map.put(discount[i], 1);
            }
        }

        int answer = 0;

        if(want()) answer++;

        if(discount.length==10) return answer;

        for(int i=10; i<discount.length; i++){
            map.put(discount[i-10], map.get(discount[i-10])-1);

            if(map.containsKey(discount[i])){
                map.put(discount[i], map.get(discount[i])+1);
            } else {
                map.put(discount[i], 1);
            }

            if(want()) answer++;
        }

        return answer;
    }

    private boolean want(){

        for(String key : wishList.keySet()){
            if(map.get(key) != wishList.get(key)) return false;
        }

        return true;
    }
}