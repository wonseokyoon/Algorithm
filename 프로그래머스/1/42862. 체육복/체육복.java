import java.util.*;
class Solution {
    public int solution(int n, int[] losts, int[] reserves) {
        int[] student = new int[n];
        Arrays.fill(student,1);
        
        int answer = n;
        
        for(int lost : losts) {
            student[lost-1] --;
        }
        
        for(int reserve : reserves){
            student[reserve-1] ++;
        }

        for(int i = 0 ; i < n; i ++){
            if(student[i] == 0){
                if(i > 0 && student[i-1] == 2) {     // 왼쪽에서 빌림
                    student[i-1] --;
                    student[i] ++;
                } else if(i < n - 1 && student[i+1] == 2) {   // 오른쪽에서 빌림
                    student[i+1] --;
                    student[i] ++;
                } else{
                    answer --;
                }
            }
        }
        
        
        return answer;
    }
}