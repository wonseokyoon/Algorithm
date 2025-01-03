import java.util.*;
class Solution {
          public int[] solution(int k, int[] score) {
        //크기가 k인 priority큐
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        int[] answer=new int[score.length];

        for(int i=0;i<score.length;i++){
            if(i<k){
                queue.add(score[i]);
                answer[i]= queue.element();
                continue;
            }
            if(score[i]> queue.element()){  // 새로 들어 온 값> 큐의 최솟값
                queue.poll();   //최솟값 제거
                queue.add(score[i]);    // 추가
                answer[i]= queue.element();
            }
            else{
                answer[i]= queue.element();
            }
        }

        return answer;
    }
}