import java.util.*;

class Solution {
    // 상 하 좌 우
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};
    
    public int solution(String[] maps) {
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];
        
        int row = maps.length;
        int col = maps[0].length();
        
        for(int i =0; i < row;i ++){
            for(int j = 0; j<col;j++){
                char c = maps[i].charAt(j);
                // 시작 지점
                if(c =='S'){
                    start = new int[]{i,j};
                }else if(c == 'E'){
                    exit = new int[]{i,j};
                } else if(c=='L'){
                    lever = new int[]{i,j};
                }
            }
        }
        
        // start -> lever 거리
        int startToLever = bfs(start,lever,maps);
        if(startToLever == -1){
            return -1;
        }

        // lever -> exit 거리
        int LeverToExit = bfs(lever,exit,maps);
        if(LeverToExit == -1){
            return -1;
        }
        
        return startToLever + LeverToExit;
    }
    
    int bfs(int[] start,int end[], String[] maps){
        int row = maps.length;
        int col = maps[0].length();
        // 현재 위치, 시간
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        
        // 초기 위치
        queue.add(new int[]{start[0],start[1],0});
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int time = cur[2];
            
            // 도착
            if(curX == end[0] && curY == end[1]){
                return time;
            }
            
            // 모든 방향 체크
            for(int i=0;i<4;i++){
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];
                
                if(nextX >= 0 && nextX < row && nextY >= 0 && nextY < col 
                  && !visited[nextX][nextY] && maps[nextX].charAt(nextY) != 'X'){
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX,nextY,time+1});
                }
            }         
        }
        
        return -1;
    }
    
    
    
}