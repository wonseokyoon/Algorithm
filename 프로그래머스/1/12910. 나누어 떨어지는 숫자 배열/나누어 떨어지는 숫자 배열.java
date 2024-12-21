import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> digits=new ArrayList<>();
        
        for(int digit:arr) {
            if (digit % divisor == 0) {   // 나누어지면
                digits.add(digit);
            }
        }
        Collections.sort(digits);   //정렬
        int len=digits.size();  // 배열 크기
        if(len==0){
            int [] answer={-1};
            return answer;
        }
        int [] answer=new int[len];
        int cnt=0;
        for(int digit:digits){
            answer[cnt++]=digit;
        }

        return answer;
    }
}