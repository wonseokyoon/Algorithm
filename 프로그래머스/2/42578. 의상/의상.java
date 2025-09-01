import java.util.*;
class Solution {
    HashMap<String,Integer> map = new HashMap<>();
    public int solution(String[][] clothes) {
        for(String[] cloth: clothes){
            String type = cloth[1];     // 의상 종류
            // 의상 종류 별 가짓수 기록
            map.put(type,map.getOrDefault(type,0) +1);
        }
        
        int[] number = new int[map.size()];
        int idx = 0;
        int total = 1;
        for(String key : map.keySet()){
            int value = map.get(key);
            number[idx++] = value;
            total *= value + 1;
        }
        
        return total-1;
    }
}