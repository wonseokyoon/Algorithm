import java.util.*;

class Solution {
    int[][] map = new int[101][101];
    boolean[][] visited = new boolean[101][101];
    
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        drawRectangle(rectangle);
        
        int distance = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        return distance/2;
    }
    
    void drawRectangle(int[][] rectangle){
        
        for(int[] r : rectangle) {
            int startX = r[0] * 2;
            int startY= r[1] * 2;
            int endX = r[2] * 2;
            int endY = r[3] * 2;
            
            // 사각형 채우기
            for(int x = startX; x <= endX; x ++) {
                for(int y = startY; y <= endY; y++) {
                    map[x][y] = 1;
                }
            }
        }
        
        for(int[] r : rectangle) {
            int startX = r[0] * 2;
            int startY= r[1] * 2;
            int endX = r[2] * 2;
            int endY = r[3] * 2;
            
            // 테두리 빼고 파내기
            for(int x = startX+1; x < endX; x ++) {
                for(int y = startY+1; y < endY; y++) {
                    map[x][y] = 0;
                }
            }
        }
    }
    
    int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{characterX, characterY,0});
        visited[characterX][characterY] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0]; 
            int currentY = current[1]; 
            int currentDistance = current[2]; 
            
            if(currentX == itemX && currentY == itemY) return currentDistance;
            
            int nextX;
            int nextY;
            
            for(int i = 0; i < 4; i ++){
                nextX = currentX + dx[i];
                nextY = currentY + dy[i];
                
                // 범위 내에 있고, 테두리를 따라가고, 방문한적 x
                if(nextX >= 0 && nextX < 101 && nextY >=0 && nextY < 101 && map[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX,nextY,currentDistance+1});
                }
            }
        }
        
        return -1;
    }
}