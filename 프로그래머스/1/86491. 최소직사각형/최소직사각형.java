import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        // 모든 명함을 담을 수 있는 지갑의 크기
        // 눕히는거 허용
        int maxW = Integer.MIN_VALUE;       // 가로 최댓값
        int maxH = Integer.MIN_VALUE;       // 세로 최댓값
        
        for(int[] size : sizes){
            // 무조건 가로가 더 길게 배치
            int width = Math.max(size[0],size[1]);
            int height = Math.min(size[0],size[1]);
            
            if(width > maxW) maxW = width;
            if(height > maxH) maxH = height;
        }
        return maxW * maxH;
    }
}