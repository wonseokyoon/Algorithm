import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> klist=new ArrayList<>();

        for(int i=0;i< commands.length;i++){
            int[] temp=Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(temp);  // 2 3 5 6
            klist.add(temp[commands[i][2]-1]);
        }
        return klist.stream().mapToInt(Integer::intValue).toArray();
    }
}