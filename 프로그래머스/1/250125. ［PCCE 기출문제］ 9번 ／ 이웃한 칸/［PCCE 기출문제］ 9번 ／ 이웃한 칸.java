class Solution {
    public int solution(String[][] board, int h, int w) {

        String color=board[h][w];
        int cnt=0;
        // 상하좌우
        int[] dh={-1,1,0,0};
        int[] dw={0,0,-1,1};

        for(int i=0;i<4;i++){
            int h_check=h+dh[i];
            int w_check=w+dw[i];

            if(h_check>=0 && h_check< board.length
                    && w_check>=0 && w_check<board.length){
                if(board[h_check][w_check].equals(color)) cnt++;
            }
        }
    return cnt;
    }
}