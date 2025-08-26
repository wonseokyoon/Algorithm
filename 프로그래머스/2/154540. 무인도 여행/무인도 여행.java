import java.util.*;

class Solution {
    int[] dx = {-1,1,0,0}; 
    int[] dy = {0,0,-1,1};
    boolean[][] visited = new boolean[101][101];
    
    public int[] solution(String[] maps) {
        int[] start = new int[2];
        int row = maps.length;
        int col = maps[0].length();
        
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i< row; i ++){
            String str = maps[i];
            for(int j = 0; j < col ; j++){
                char ch = str.charAt(j);
                // 바다 나오면 pass
                if(ch =='X') continue;
                if(visited[i][j]) continue;
                
                start = new int[] {i,j};
                // 인접한 모든 섬 탐색
                int sum = bfs(maps,start,ch);
                answer.add(sum);            // 정답 리스트에 등록
            }
        }
        if(answer.isEmpty()) return new int[]{-1};

        Collections.sort(answer);
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    int bfs(String[] maps,int[] start,char ch) {
        int row = maps.length;
        int col = maps[0].length();
    
        Queue<int[]> queue = new LinkedList<>();
        int number = ch -'0';
        System.out.println("number: " +number);
        
        visited[start[0]][start[1]] = true;
        queue.offer(new int[]{start[0],start[1]});
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];  // 0
            int currentY = current[1];  // 1
            
            // 상하좌우 탐색
            for(int i = 0; i< 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                // 인접한 섬 발견
                if(nextX >=0 && nextX <row && nextY >=0 && nextY <col && !visited[nextX][nextY] 
                   && maps[nextX].charAt(nextY) != 'X'){
                    int newNumber = maps[nextX].charAt(nextY) - '0';
                    
                    visited[nextX][nextY] = true;     // 방문 처리
                    queue.offer(new int[]{nextX,nextY});    // 큐에 등록                
                    number += newNumber;       // 합
                }
            }
        }
        
        return number;
    }
}