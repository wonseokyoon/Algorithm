import java.util.*;

class Solution {
    int[] dx = {-1,1,0,0}; 
    int[] dy = {0,0,-1,1};
    boolean[][] visited;
    int row;
    int col;
    
    public int[] solution(String[] maps) {
        int[] start = new int[2];
        row = maps.length;
        col = maps[0].length();
        visited = new boolean[row][col];
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i< row; i ++){
            String str = maps[i];
            for(int j = 0; j < col ; j++){
                char ch = str.charAt(j);
                // 섬 or 방문한 적 없음
                if(ch !='X' && !visited[i][j]){
                    start = new int[] {i,j};
                    int number = ch -'0';
                    int sum = dfs(maps,start,number);   // DFS(깊이 우선 탐색)
                    answer.add(sum);            // 정답 리스트에 등록        
                }
            }
        }
        if(answer.isEmpty()) return new int[]{-1};

        Collections.sort(answer);
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    int dfs(String[] maps,int[] start,int number) {
        visited[start[0]][start[1]] = true;
        
        int currentX = start[0];  
        int currentY = start[1];  
        
        // 상하좌우 탐색
        for(int i = 0; i< 4; i++){
            int nextX = currentX + dx[i];
            int nextY = currentY + dy[i];
            // 인접한 섬 발견
            if(nextX >=0 && nextX <row && nextY >=0 && nextY <col && !visited[nextX][nextY] 
               && maps[nextX].charAt(nextY) != 'X'){
                int newNumber = maps[nextX].charAt(nextY) - '0';

                visited[nextX][nextY] = true;     // 방문 처리
                number += dfs(maps,new int[]{nextX,nextY},newNumber);       // 합
            }
        }
        
        System.out.println("number: " +number);
        return number;
    }
}