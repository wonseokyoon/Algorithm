import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] wires) {

        visited = new boolean[n+1];
        int min = n;
        
        for(int[] wire : wires) {
            int towerA = wire[0];
            int towerB = wire[1];
            int cnt = 0;
            
            visited[towerA] = true;
            visited[towerB] = true;
            
            cnt += dfs(towerA,wires);
            
            visited[towerA] = false;
            visited[towerB] = false;
            
            min = Math.min(min, Math.abs(n - cnt - cnt));
        }
        
        return min;
    }
    
    int dfs(int target, int[][] wires){
        
        int cnt = 1;
        for(int[] wire : wires) {
            int towerA = wire[0];
            int towerB = wire[1];
            
            if(target == towerA && !visited[towerB]) {
                visited[towerB] = true;
                cnt += dfs(towerB,wires);                
                visited[towerB] = false;
            } else if(target == towerB && !visited[towerA]){ 
                visited[towerA] = true;
                cnt += dfs(towerA,wires);                
                visited[towerA] = false;
            }
        }
        
        return cnt;
    }
}