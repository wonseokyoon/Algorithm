import java.util.*;
class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int solution(String[] maps) {
        int row = maps.length;
        int col = maps[0].length();
        
        int[] start = new int[2];
        int[] exit = new int[2];
        int[] lever = new int[2];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(maps[i].charAt(j) == 'S'){
                    start = new int[]{i,j};    
                } else if(maps[i].charAt(j) == 'L'){
                    lever = new int[]{i,j};
                } else if(maps[i].charAt(j) == 'E'){
                    exit = new int[]{i,j};
                }
            }
        }
        
        int startToLever = bfs(start,lever,maps);
        if(startToLever == -1) return -1;
        int leverToExit = bfs(lever,exit,maps);
        if(leverToExit == -1) return -1;
        
        return leverToExit + startToLever;        
    }
    
    int bfs(int[] start, int[] end, String[] maps){
        int row = maps.length;
        int col = maps[0].length();
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        
        queue.add(new int[] {start[0], start[1], 0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int time = cur[2];
            
            if(curX == end[0] && curY == end[1]){
                return time;
            }
            
            for(int i = 0; i< 4 ; i++){
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