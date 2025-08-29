import java.util.*;
class Solution {
    ArrayList<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n,1,2,3);        
        
        return list.toArray(new int[0][]);
    }
    
    void hanoi(int num, int start, int via, int end){
        if(num == 1){
            list.add(new int[] {start,end});
            return;
        }
        
        // 가장 큰 원반 제외, 모든 원반을 start -> via로 이동
        hanoi(num-1, start,end,via);
        // 가장 큰 원반을 start -> end로 이동
        list.add(new int[] {start,end});
        // 나머지 원반을 via -> end로 이동
        hanoi(num-1, via,start,end);
        
        
    }
    
}