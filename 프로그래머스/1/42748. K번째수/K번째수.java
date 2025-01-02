import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> klist=new ArrayList<>();

        for(int i=0;i< commands.length;i++){
            ArrayList<Integer> nlist=new ArrayList<>();
            for(int j=commands[i][0]-1;j<commands[i][1];j++){
                nlist.add(array[j]);
            }
            Collections.sort(nlist);
            klist.add(nlist.get(commands[i][2]-1));
        }
        return klist.stream().mapToInt(Integer::intValue).toArray();
    }
}