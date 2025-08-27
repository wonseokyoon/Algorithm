import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data,(a,b) -> {
            if(a[col-1] == b[col-1]) {  // 같으면
                return b[0] - a[0];     // 첫번째로 내림차순 정렬
            }
            return a[col-1] - b[col-1];
        });
        
        int diff = row_end - row_begin;
        int[] sIList = new int[diff+1];
        int si = 0;
        for(int i=row_begin-1; i<=row_end-1;i++){
            int[] row = data[i];
            si ^= calSI(row,i+1);       // SI 계산
        }
        return si;
    }
    
    int calSI(int[] row,int idx){
        int si = 0;
        for(int data:row){
            si += data%idx;
        }                  
        return si;
    }
}