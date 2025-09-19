import java.util.*;

class Solution {
    boolean[][] visited;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] maps = new int[n+1][m+1];   // 지도
        visited = new boolean[n+1][m+1];
        
        for(int[] puddle : puddles) {
            int px = puddle[0];
            int py = puddle[1];
            visited[py][px] = true;
        }
        
        for(int i = 1; i < n+1 ; i ++) {
            if(visited[i][1]) break;
            maps[i][1] = 1;
        }
        for(int i = 1; i < m+1 ; i ++) {
            if(visited[1][i]) break;
            maps[1][i] = 1;
        }
        
        for(int i = 2; i < n+1; i++){
            for(int j = 2; j < m+1; j++) {
                if(!visited[i][j]){
                    maps[i][j] = (maps[i-1][j] + maps[i][j-1]) % 1000000007;
                }
            }
        }
        
        int answer = maps[n][m];
        return answer;
    }
}