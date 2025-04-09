import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int size = elements.length;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < size; i++){
            int sum = 0;
            for(int j = 0; j < size; j++){
                sum += elements[(i+j)%size];
                map.put(sum, map.getOrDefault(sum, 0));
            }
        }

        return map.size();
    }
}