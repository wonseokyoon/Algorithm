import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] wires) {
        visited = new boolean[n+1];
        int answer = n;
        int cnt = 1;
        for(int[] wire : wires) {
            int towerA = wire[0];
            int towerB = wire[1];

            // towerA와 연결된 타워의 갯수
            visited[towerA] = true;
            visited[towerB] = true;
            cnt = dfs(towerA,wires);
            visited[towerA] = false;
            visited[towerB] = false;
            
            answer = Math.min(Math.abs((n - cnt) - cnt),answer);
        }
        return answer;
    }
    
    public int dfs(int towerA, int[][] wires){
        int cnt = 1;
        
        for(int i = 0; i < wires.length; i++) {
            int[] wire = wires[i];
            
            if(towerA == wire[0] && !visited[wire[1]]){
                visited[wire[1]] = true;
                cnt += dfs(wire[1], wires);
                visited[wire[1]] = false;
            } else if(towerA == wire[1] && !visited[wire[0]]){
                visited[wire[0]] = true;
                cnt += dfs(wire[0], wires);
                visited[wire[0]] = false;
            }
        }
        
        return cnt;
    }
}