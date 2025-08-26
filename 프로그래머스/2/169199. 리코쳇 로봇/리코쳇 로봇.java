import java.util.*;
class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    int row;
    int col;
    boolean[][] visited;
    
    public int solution(String[] board) {
        row = board.length;
        col = board[0].length();
        visited = new boolean[row][col];
        
        for(int i = 0;i < row; i++){
            String str = board[i];
            for(int j = 0; j < col; j++){
                char ch = str.charAt(j);
                int[] start = new int[2];
                start = new int[]{i,j};
                if(ch == 'R'){
                    // bfs 로 최단거리 계산
                    int cnt = bfs(board,start);
                    return cnt;
                }
            }
        }
        
        return -1;
    }
    
    int bfs(String[] board, int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        
        // [x좌표,y좌표,이동 횟수]
        queue.offer(new int[]{start[0],start[1],0});
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
            int cnt = current[2];
            
            // System.out.println("현재 위치: " + currentX+","+currentY);
            
            // 도착
            if(board[currentX].charAt(currentY) == 'G') {
                return cnt;
            }
            
            // 모든 방향 탐색
            for(int i=0;i<4;i++){
                int nextX = currentX +dx[i];
                int nextY = currentY +dy[i];
                
                // 격자 범위 이내 & 끝까지 이동
                while(nextX >= 0 && nextX <row && nextY >= 0 && nextY <col 
                      && board[nextX].charAt(nextY) != 'D') {
                    nextX += dx[i];
                    nextY += dy[i];
                }
                // 직전 위치
                nextX -= dx[i];
                nextY -= dy[i];
                if(!visited[nextX][nextY]) {                // 처음 와본 정지구역
                    queue.offer(new int[]{nextX,nextY, cnt+1});    // 위치 저장
                    visited[nextX][nextY] = true;           // 방문 처리
                }
            }
        }
        return -1;        
    }
}