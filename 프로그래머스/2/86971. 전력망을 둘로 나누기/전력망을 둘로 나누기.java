import java.util.*;
class Solution {
    boolean[] visited;
    int answer;
    public int solution(int n, int[][] wires) {
        answer = n;
        visited = new boolean[n+1];
        
        for(int[] wire : wires){
            int towerA = wire[0];
            int towerB = wire[1];
            visited[towerB] = true;
            visited[towerA] = true;
            int cnt = dfs(towerA,wires,n);  // towerA와 연결된 타워만 찾으면 됨
            visited[towerA] = false;
            visited[towerB] = false;
            
            answer = Math.min(Math.abs(n - (2 * cnt)), answer);
        }
        
        return answer;
    }
    
    int dfs(int towerA, int[][] wires, int n){
        int cnt = 1;
        for(int[] wire : wires){
            
            // 연결된 송전탑 찾음(방문한적 x)
            if(wire[0] == towerA && !visited[wire[1]]) {
                visited[wire[1]] = true;    // 방문 처리
                cnt += dfs(wire[1],wires,n); // dfs
                visited[wire[1]] = false;   // 백트래킹

            } else if(wire[1] == towerA && !visited[wire[0]]) {
                visited[wire[0]] = true;    // 방문 처리
                cnt += dfs(wire[0],wires, n); // dfs
                visited[wire[0]] = false;   // 백트래킹
            }
        }
        
        return cnt;
    }
    
}