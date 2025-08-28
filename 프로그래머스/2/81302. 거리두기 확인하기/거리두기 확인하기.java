import java.util.*;
class Solution {
    char[][] board;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i =0;i<5;i++){
            String[] place = places[i];
            if(isOk(place)){
                answer[i] = 1;
            } else{
                answer[i] = 0;
            }
        }
        return answer;
    }
    
    boolean isOk(String[] place){
        board = new char[5][5];
        
        for(int i =0; i < 5; i++){
            String row = place[i];  // 한 행
            for(int j = 0; j<5;j++){
                board[i][j] = row.charAt(j);                
            }
        }
        
        for(int i =0; i < 5; i++){
            for(int j = 0; j<5;j++){
                char ch = board[i][j];
                
                // 사람이 앉아있으면
                if(ch == 'P'){
                    if(!confirmStraight(i,j,board)) { // 직선 확인
                        return false;
                    }
                    if(!confirmDiagonal(i,j,board)) { // 대각선 확인
                        return false;
                    }
                }
            }
        }
        // 전부 통과
        return true;
    }
    
    // 직선 방향에서 규칙 지켰는지
    boolean confirmStraight(int rowIdx,int colIdx,char[][] board) {
        int checkRow;
        int checkCol;
        // 거리가 2
        checkRow = rowIdx + 2;
        checkCol = colIdx + 2;
        if(checkRow < 5){
            if(board[checkRow][colIdx] == 'P') { // 사람이 있음 -> 칸막이 확인
                int between = (checkRow + rowIdx)/2;
                if(board[between][colIdx] != 'X') {    // 사이에 칸막이가 없으면
                    return false;
                }   
            }
        }
        if(checkCol < 5) { // 범위 벗어나면 pass
            if(board[rowIdx][checkCol] == 'P') { // 사람이 있음 -> 칸막이 확인
                int between = (checkCol + colIdx)/2;
                if(board[rowIdx][between] != 'X') {    // 사이에 칸막이가 없으면
                    return false;
                }        
            }   
        }
        
        // 거리가 1
        checkRow = rowIdx + 1;
        checkCol = colIdx + 1;
        if(checkRow < 5) { // 범위 벗어나면 pass
            if(board[checkRow][colIdx] == 'P') return false;   // 사람이면 아웃
        }  
        if(checkCol <5) { // 범위 벗어나면 pass
            if(board[rowIdx][checkCol] == 'P') return false;   // 사람이면 아웃
        }  
        
        return true;
    }
    
    // 대각선 방향에서 규칙 지켰는지
    boolean confirmDiagonal(int rowIdx,int colIdx,char[][] board){
        int checkRow;
        int checkCol;
        
        checkRow = rowIdx + 1;
        for(int i = -1 ; i <=1; i+=2){
            checkCol = colIdx + i;
            if(checkRow < 5 && checkCol >= 0 && checkCol < 5){
                if(board[checkRow][checkCol] == 'P') {      // 사람 
                    // 직선에 전부 칸막이 존재
                    if(board[checkRow][colIdx] != 'X') return false;
                    if(board[rowIdx][checkCol] != 'X') return false;
                }
            }    
        }
        return true;
    }
    
}