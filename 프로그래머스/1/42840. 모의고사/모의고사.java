import java.util.*;
class Solution {
   public int[] solution(int[] answers) {
        int[] score=new int[3];

        int[] pattern1={1,2,3,4,5};
        int l1=pattern1.length;
        int[] pattern2={2,1,2,3,2,4,2,5};
        int l2=pattern2.length;
        int[] pattern3={3,3,1,1,2,2,4,4,5,5};
        int l3=pattern3.length;

        // 6 -> 1, 4, 2
        for(int i=0;i< answers.length;i++){
            if(answers[i] == pattern1[i%l1] ){
                score[0]++;
            }
            if(answers[i] == pattern2[i%l2] ){
                score[1]++;
            }
            if(answers[i] == pattern3[i%l3] ){
                score[2]++;
            }
        }
        List<Integer> answer=new ArrayList<>();
        int maxx=(int)Math.max(score[0],Math.max(score[1],score[2]));

        if(maxx==score[0]){
            answer.add(1);
        }
        if (maxx==score[1]) {
            answer.add(2);
        }
        if (maxx==score[2]) {
            answer.add(3);
        }

        int[] answer2=new int[answer.size()];
        for(int i=0;i< answer.size();i++){
            answer2[i]=answer.get(i);
        }


        return answer2;
    }
}