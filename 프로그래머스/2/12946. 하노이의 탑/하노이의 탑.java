import java.util.*;
class Solution {
    ArrayList<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        
        hanoi(n,1,2,3);
        return list.toArray(new int[0][]);        
    }
    
    void hanoi(int n, int start, int via, int to) {
        if(n == 1){
            list.add(new int[] {start,to});
            return;
        }
        
        // 1~n-1 의 원판: start -> via
        hanoi(n-1,start,to,via);
        // n: start -> to
        list.add(new int[] {start,to});
        // 1~n-1 의 원판: via -> to
        hanoi(n-1,via,start,to);
    }
    
}