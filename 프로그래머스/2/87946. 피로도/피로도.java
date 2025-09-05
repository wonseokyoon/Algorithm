import java.util.*;
class Solution {
    boolean[] visited;
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(k,dungeons,0);
        return max;
    }
    
    void dfs(int k, int[][] dungeons,int cnt){
        
        for(int i = 0 ; i< dungeons.length; i++){
            int minK = dungeons[i][0];     // 최소 필요도
            int requestK = dungeons[i][1];  // 요구 피로도
            
            // 방문한 적 없고, 요구 피로도를 만족
            if(!visited[i] && k >= minK){
                visited[i] = true;  // 방문 처리
                dfs(k - requestK,dungeons,cnt+1);
                visited[i] = false;     // 백트래킹
            }            
        }
        
        if(max < cnt) max = cnt;
    }
}