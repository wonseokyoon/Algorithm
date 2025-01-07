import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score); //오름차순 정렬
        // 1 1 2 2 2 2 4 4 4 4 4 4
        int answer=0;
        for(int i= score.length;i>=m;i-=m){
            answer+=score[i-m]*m;
        }
        return answer;
        
        
    }
}