import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int s1 = 0;
        int s2 = 0;
        int s3 = 0;

        int[] pattern1={1,2,3,4,5};
        int l1=pattern1.length;
        int[] pattern2={2,1,2,3,2,4,2,5};
        int l2=pattern2.length;
        int[] pattern3={3,3,1,1,2,2,4,4,5,5};
        int l3=pattern3.length;

        // 6 -> 1, 4, 2
        for(int i=0;i< answers.length;i++){
            if(answers[i] == pattern1[i%l1] ){
                s1++;
            }
            if(answers[i] == pattern2[i%l2] ){
                s2++;
            }
            if(answers[i] == pattern3[i%l3] ){
                s3++;
            }
        }
        List<Integer> answer=new ArrayList<>();
        int maxx=(int)Math.max(s1,s2);
        maxx=(int)Math.max(maxx,s3);


        if(maxx==s1){
            answer.add(1);
        }
        if (maxx==s2) {
            answer.add(2);
        }
        if (maxx==s3) {
            answer.add(3);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}