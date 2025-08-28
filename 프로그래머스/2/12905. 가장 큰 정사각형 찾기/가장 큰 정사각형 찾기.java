import java.util.*;
class Solution {
    int[][] dp;
    int[] dr ={-1,0,-1};
    int[] dc ={0,-1,-1};
    
    public int solution(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        dp = new int[row][col];
        int answer = 0;
                
        for(int i =0 ; i<row; i++){
            for (int j = 0; j<col ; j++){
                int num = board[i][j];
                if(num == 1) {
                    int number = getDp(board,i,j);
                    // 최댓값 갱신
                    if(answer < number) answer = number;
                }
            }
        }
        
        // 넓이
        return (int) Math.pow(answer,2);
    }
    
    int getDp(int[][] board,int row,int col){
        int neighborRow;
        int neighborCol;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i<3;i++){
            neighborRow = row + dr[i];
            neighborCol = col + dc[i];
            
            // 범위를 벗어나면
            if(neighborRow < 0 || neighborCol < 0){
                min = 0;
            } else{
                // 최솟값 갱신
                min = Math.min(min, dp[neighborRow][neighborCol]);
            }
        }
        
        // 근처 숫자들의 최솟값 + 1
        dp[row][col] = min + 1;
        return min+1;
    }
}