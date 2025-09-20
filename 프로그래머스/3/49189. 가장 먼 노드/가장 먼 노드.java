import java.util.*;
class Solution {
    boolean[] visited;
    ArrayList<HashSet<Integer>> distances = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        Arrays.sort(edge, (a,b) -> a[0] - b[0]);
        
        visited = new boolean[n+1];
        visited[1] = true;
        
        bfs(1,n,edge);
        
        HashSet<Integer> lastSet = distances.get(distances.size() - 1);
        return lastSet.size();
    }
    
    void bfs(int start, int n, int[][] edge) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{start,0});    // 출발지, 거리
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentStart = current[0];
            int currentDistance = current[1];
            
            for(int[] e : edge) {
                int node1 = e[0];
                int node2 = e[1];
                
                int neighbor = 0;
                if(node1 == currentStart && !visited[node2]){
                    neighbor = node2;
                } else if(node2 == currentStart && !visited[node1]){
                    neighbor = node1;
                }
                
                if(neighbor != 0) {
                    visited[neighbor] = true;
                    int nextDistance = currentDistance+1;
                    queue.offer(new int[]{neighbor,nextDistance});
                    
                    while(distances.size() <= nextDistance){
                        distances.add(new HashSet<>());
                    }
                    distances.get(nextDistance).add(neighbor);
                }
            }
        }
    }
}