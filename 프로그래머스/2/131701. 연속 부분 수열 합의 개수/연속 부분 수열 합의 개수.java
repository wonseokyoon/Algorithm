import java.util.*;

class Solution {
     public int solution(int[] elements) {
        int size = elements.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < size; i++){
            int sum = 0;
            for(int j = 0; j < size; j++){
                sum += elements[(i+j)%size];
                set.add(sum);
            }
        }
        return set.size();
    }
}