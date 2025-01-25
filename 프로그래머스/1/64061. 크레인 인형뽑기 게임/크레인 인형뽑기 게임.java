import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack=new Stack<>();
        int cnt=0;
        for(int i=0;i< moves.length;i++){
            int index=moves[i]-1;
            for(int j=0;j< board.length;j++){
                if(board[j][index]!=0){
                    stack.push(board[j][index]);
                    board[j][index]=0;
                    break;
                }
            }
            if(stack.size()>=2
                    && stack.get(stack.size() - 1).equals(stack.get(stack.size() - 2))){
                cnt+=2;
                stack.pop();
                stack.pop();
            }
        }

        return cnt;
    }
}