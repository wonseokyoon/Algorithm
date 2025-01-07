import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score); //오름차순 정렬

        int[] ans=new int[score.length];
        // 내림차순 정렬
        for(int i=0;i< score.length;i++){
            ans[i]=score[score.length-1-i];
        }
//        System.out.println(Arrays.toString(ans));

        int box= score.length/m;    // 박스의 개수
        int boxScore=0 ;  // 각 상자의 점수

        for(int i=0;i<box;i++){
            boxScore+=ans[i*m+(m-1)]*m;
//            System.out.println(ans[i*m]);
        }
//        System.out.println(box);
        return boxScore;
    }
}