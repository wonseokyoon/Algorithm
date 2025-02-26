import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets,Comparator.comparingInt(o->o[1]));

        int intercept=Integer.MIN_VALUE;
        int cnt=0;

        for(int[] target:targets){
            // 요격안되는경우
            if(target[0]>=intercept){
                cnt++;
                intercept=target[1];    // 끝에 발사
            }
        }
        return cnt;
    }

}