import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int solution(int[][] sizes) {
        for(int[] size: sizes){
            Arrays.sort(size);
            Collections.reverse(Arrays.asList(size));   //큰 값이 앞으로
        }
        int max1=sizes[0][0];
        int max2=sizes[0][1];
        for(int i=0;i< sizes.length;i++){
            if(max1<sizes[i][0]) max1=sizes[i][0];
            if(max2<sizes[i][1]) max2=sizes[i][1];
        }
        int answer = max1*max2;
        return answer;
    }
}