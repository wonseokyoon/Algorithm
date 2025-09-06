import java.util.*;
class Solution {
    int[] answer = new int[2];
    
    public int[] solution(int brown, int yellow) {
        int totalCnt = brown + yellow;  // 전체 격자 갯수
        
        dfs(2,yellow, totalCnt);
        
        return answer;
    }
    
    void dfs(int width, int target, int totalCnt) {
        
        if(totalCnt % width == 0) {
            int height = totalCnt / width;  // 높이
            if(width < height) dfs(width + 1, target, totalCnt);
            else{
                if((width - 2) * (height - 2) == target) {
                    // answer[0] = width;
                    // answer[1] = height;
                    answer = new int[] {width, height};
                    return;
                }
                dfs(width + 1, target, totalCnt);   
            }
        } else{
            dfs(width + 1, target, totalCnt);   
        }
        
    }
}