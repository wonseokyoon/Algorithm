import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        for(int i = 0; i < n; i ++){
            if(!visited[i]){
                dfs(i,computers);
                answer ++;
            }
        }
        
        return answer;
    }
    
    void dfs(int idx , int[][] computers) {
        
        int[] computer = computers[idx];
        
        for(int i =0; i < computer.length; i ++) {
            // 연결된 컴퓨터를 찾음
            if(computer[i] == 1 && !visited[i]) {
                visited[idx] = true;
                dfs(i,computers);
            } 
        }
    }
}