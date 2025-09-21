import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n+1][n+1];
        
        // 승패 유무 저장
        for(int[] result : results){
            int win = result[0];
            int lose = result[1];
            graph[win][lose] = true;
        }
        
        // i가 k를 이기고, k가 j를 이기면, i 가 j를 이김
        for(int k =1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(graph[i][k] && graph[k][j]){
                        graph[i][j] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 1 ; i <=n; i ++){
            int cnt = 0;
            for(int j = 1; j<=n; j++){
                if(graph[i][j] || graph[j][i]) cnt ++;
            }
            if(cnt == n-1) answer ++;
        }
        
        return answer;
    }
}