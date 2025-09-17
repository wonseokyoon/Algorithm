import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int temp = m;
        m = n;
        n = temp;
        
        int[][] dp = new int[n][m];
        boolean[][] puddle = new boolean[n][m];
        for(int[] p : puddles) {
            int x = p[0] - 1;
            int y = p[1] - 1;
            puddle[x][y] = true;
        }
        
        dp[0][0] = 0;
        for(int i = 1; i < n; i ++){
            // 가는길이 멀쩡하면 전부 1
            if(!puddle[i][0]) dp[i][0] = 1;
            else break;
        }
        
        for(int i = 1; i < m; i ++){
            // 가는길이 멀쩡하면 전부 1
            if(!puddle[0][i]) dp[0][i] = 1;
            else break;
        }
        

        for(int i = 1; i < n; i ++){
            for(int j = 1; j < m ; j ++){
                if(puddle[i][j]) continue;

                dp[i][j] = (dp[i-1][j] + dp[i][j-1])% 1000000007;
            }
        }
        
        int answer = dp[n-1][m-1];
        return answer;
    }
}