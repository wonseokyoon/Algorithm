import java.util.*;
class Solution {
    boolean[][] visited;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    int row;
    int col;
    
    public int solution(int[][] maps) {
        row = maps.length;
        col = maps[0].length;
        visited = new boolean[row][col];
        
        int answer = bfs(0,0,1,maps);
        return answer;
    }
    
    int bfs(int x,int y, int distance,int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y,distance});
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int currentDistance = current[2];
            visited[currentX][currentY] = true;
            
            if(currentX == row-1 && currentY == col-1) return currentDistance;
            
            int nextX;
            int nextY;
            for(int i =0 ; i < 4; i ++){
                nextX = currentX + dx[i];
                nextY = currentY + dy[i];
                
                // 범위 내에서, 방문한적 없고, 벽이 아님
                if(nextX >= 0 && nextX < row && nextY >= 0 && nextY < col && !visited[nextX][nextY] && maps[nextX][nextY] == 1){
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX,nextY,currentDistance+1});
                }
            }
        }
        
        return -1;
    }
}