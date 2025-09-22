import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        int answer = 0;
        
        for(int i= 0; i < n; i ++){
            if(!visited[i]) {
                dfs(i,computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    void dfs(int node,int[][] computers){
        
        int[] computer = computers[node];
        for(int i = 0 ; i < computer.length; i++) {
            if(!visited[i] && computer[i] == 1){
                visited[i] = true;
                dfs(i,computers);
            }
        }
    }
}