import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int length = triangle.length;
        
        int[][] dp = new int [length][length];
        dp[0][0] = triangle[0][0];
        for(int i = 1; i< length;i++){
            int[] period = dp[i-1];
            for(int j = 0; j < i+1; j++ ){
                int maxNum;
                if(j == 0){
                    maxNum = period[0];
                } else maxNum = Math.max(period[j-1] , period[j]);
                
                int current = triangle[i][j];
                dp[i][j] = maxNum + current;
            }
        }
        
        int[] lastDp = dp[length - 1];
        int max = Arrays.stream(lastDp).max().getAsInt();
        return max;
    }
}