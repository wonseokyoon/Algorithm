import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] person1 = {1,2,3,4,5};                // 5
        int[] person2 = { 2, 1, 2, 3, 2, 4, 2, 5};  // 8
        int[] person3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};    // 10
        
        int totalCnt = answers.length;
        int cnt = 0;
        int score1 =0;
        int score2 =0;
        int score3 =0;
        while(cnt < totalCnt) {
            int ans = answers[cnt];
            if(ans == person1[cnt%5]){
                score1 ++;
            }
            if(ans == person2[cnt%8]){
                score2 ++;
            }
            if(ans == person3[cnt%10]){
                score3 ++;
            }
            cnt ++;
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        int max = (int) Math.max(Math.max(score1,score2),score3);
        if(max == score1){
            answer.add(1);
        }
        if(max == score2){
            answer.add(2);
        }
        if(max == score3){
            answer.add(3);
        }       
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}