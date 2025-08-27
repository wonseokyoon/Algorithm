import java.util.*;
class Solution {
    // 시계방향 순서: ➡️⬇️⬅️⬆️
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    int[][] board;
    int minNumber = Integer.MAX_VALUE;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        board = new int[rows+1][columns+1];
        int number = 1;
        int[] answer = new int[queries.length];
        
        for(int i=1;i<=rows;i++){
            for(int j = 1;j<=columns;j++){
                board[i][j] = number++;
            }
        }
        
        int idx =0;
        for(int[] query : queries){
            int startX = query[0];
            int startY = query[1];
            int endX = query[2];
            int endY = query[3];
            
            // 총 움직일 거리
            int dRow = endX - startX;
            int dCol = endY - startY;
            
            // 이동
            move(startX,startY,endX,endY,dRow,dCol);
            answer[idx++] = minNumber;
        }
        
        return answer;
    }
    
    void move(int startX,int startY,int endX,int endY,int dRow,int dCol){
        // [x좌표,y좌표,값]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX,startY,board[startX][startY]});
        
        int[] current = new int[3];
        int currentX;
        int currentY;
        int currentNumber;
        int newNumber;
        int nextX;
        int nextY;
        minNumber = board[startX][startY];
        // ➡️
        for(int i = 0; i< dCol; i++){
            current = queue.poll(); // 기존 값 추출
            currentX = current[0];  // x좌표
            currentY = current[1];  // y좌표
            currentNumber = current[2]; // 값
            
            nextX = currentX + dx[0];
            nextY = currentY + dy[0];
            newNumber = board[nextX][nextY];
            if(newNumber < minNumber) minNumber = newNumber;
            
            // 새로운 값 큐에 주입
            queue.offer(new int[]{nextX,nextY,newNumber});
            // 기존 값 이동 한 칸에 주입
            board[nextX][nextY] = currentNumber;
        }
        // ⬇️
        for(int i = 0; i< dRow; i++){
            current = queue.poll(); // 기존 값 추출
            currentX = current[0];  // x좌표
            currentY = current[1];  // y좌표
            currentNumber = current[2]; // 값
            
            nextX = currentX + dx[1];
            nextY = currentY + dy[1];
            newNumber = board[nextX][nextY];
            if(newNumber < minNumber) minNumber = newNumber;
            
            // 새로운 값 큐에 주입
            queue.offer(new int[]{nextX,nextY,newNumber});
            // 기존 값 이동 한 칸에 주입
            board[nextX][nextY] = currentNumber;
            
        }
        // ⬅️
        for(int i = 0; i< dCol; i++){
            current = queue.poll(); // 기존 값 추출
            currentX = current[0];  // x좌표
            currentY = current[1];  // y좌표
            currentNumber = current[2]; // 값
            
            nextX = currentX + dx[2];
            nextY = currentY + dy[2];
            newNumber = board[nextX][nextY];
            if(newNumber < minNumber) minNumber = newNumber;
            
            // 새로운 값 큐에 주입
            queue.offer(new int[]{nextX,nextY,newNumber});
            // 기존 값 이동 한 칸에 주입
            board[nextX][nextY] = currentNumber;
        }
        // ⬆️
        for(int i = 0; i< dRow -1; i++){
            current = queue.poll(); // 기존 값 추출
            currentX = current[0];  // x좌표
            currentY = current[1];  // y좌표
            currentNumber = current[2]; // 값
            
            nextX = currentX + dx[3];
            nextY = currentY + dy[3];
            newNumber = board[nextX][nextY];
            if(newNumber < minNumber) minNumber = newNumber;
            
            // 새로운 값 큐에 주입
            queue.offer(new int[]{nextX,nextY,newNumber});
            // 기존 값 이동 한 칸에 주입
            board[nextX][nextY] = currentNumber;
        }
        // 시작 위치
        board[startX][startY] = queue.poll()[2];
    }
}