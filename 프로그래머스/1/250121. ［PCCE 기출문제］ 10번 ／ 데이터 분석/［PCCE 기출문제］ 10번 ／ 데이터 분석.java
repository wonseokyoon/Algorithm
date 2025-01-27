import java.util.*;
class Solution {
   public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        String[] command={"code","date","maximum","remain"};
        List<String> list=Arrays.asList(command);

        int val1=list.indexOf(ext);
        int val2=list.indexOf(sort_by);

        int[][] answer= Arrays.stream(data).filter(o1 -> o1[val1]<val_ext)
                .sorted((o1, o2) -> o1[val2]-o2[val2]).toArray(int[][]::new);
        return answer;
    }
}