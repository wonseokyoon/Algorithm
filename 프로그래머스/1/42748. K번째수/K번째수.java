import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int[] command : commands){
            int start = command[0];
            int end = command[1];
            int idx = command[2];
            ArrayList<Integer> list = new ArrayList<>();
            
            for(int i = start-1; i < end; i++){
                list.add(array[i]);
            }
            Collections.sort(list);
            answer.add(list.get(idx-1));
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}