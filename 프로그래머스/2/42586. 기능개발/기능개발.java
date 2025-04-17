import java.util.*;
class Solution {
public int[] solution(int[] progresses, int[] speeds) {
        int size = progresses.length;
        int[] remains = new int[size];

        for(int i = 0; i < size; i++){
            int speed = speeds[i];
            int remain = (100 - progresses[i]);
            if(remain % speed == 0){
                remains[i] = remain/speed;
            }else {
                remains[i] = remain/speed + 1;
            }
            
        }

        ArrayList<Integer> result = new ArrayList<>();
        int prev = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int remain:remains){
            if(remain > prev) {
                map.put(remain, map.getOrDefault(remain, 0) + 1);
                if(prev != -1 ) result.add(map.get(prev));
                prev = remain;
            }
            else map.put(prev, map.getOrDefault(prev, 0) +1);
        }
        result.add(map.get(prev));

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}