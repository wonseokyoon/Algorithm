import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(String operation : operations){
            String command = operation.split(" ")[0];
            int number = Integer.parseInt(operation.split(" ")[1]);
            
            if(command.equals("I")){
                map.put(number,map.getOrDefault(number,0) +1);
            } else{
                if(map.size() > 0){
                    if(number == -1) {  // 최솟값 제거
                        int firstKey = map.firstKey();
                        int cnt = map.get(firstKey);
                        if(cnt > 1) {
                            map.put(firstKey,cnt - 1);
                        } else{
                            map.remove(firstKey);
                        }
                    } else{             // 최댓값 제거
                        int lastKey = map.lastKey();
                        int cnt = map.get(lastKey);
                        if(cnt > 1) {
                            map.put(lastKey,cnt - 1);
                        } else{
                            map.remove(lastKey);
                        }
                    }
                }
            }
        }
        if(map.size() == 0) return new int[]{0,0};
        return new int[]{map.lastKey(),map.firstKey()};
    }
}