import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        // key 값을 기준으로 정렬된 TreeMap
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(String operation: operations){
            String[] params = operation.split(" ");
            String command = params[0]; // 명령어
            int number = Integer.parseInt(params[1]);  // 숫자
            if(command.equals("I")){   // 삽입 명령어
                map.put(number, map.getOrDefault(number,0) + 1);
            } else {    // 삭제 명령어
                if (map.size() > 0){
                   if(number > 0) {     // 최댓값 삭제
                       int lastKey = map.lastKey();
                       int cnt = map.get(lastKey);
                       if(cnt == 1){
                           map.remove(lastKey);
                       } else {
                           map.put(lastKey, cnt - 1);
                       }
                   } else {  // 최솟값 삭제
                       int firstKey = map.firstKey();
                       int cnt = map.get(firstKey);
                       if(cnt == 1){
                           map.remove(firstKey);
                       } else {
                           map.put(firstKey, cnt - 1);
                       }
                   }
                }
            }
        }
        if(map.size()  == 0) return new int[]{0,0};
        
        return new int[]{map.lastKey(), map.firstKey()};
    }
}