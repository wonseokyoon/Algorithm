import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        LinkedList<Integer> number = new LinkedList<>();
        int[] answer = new int[n];
        long[] factArray = new long[n+1];

        factArray[0] = 1;
        for(int i = 1;i<=n;i++){
            factArray[i] = i * factArray[i-1];
            number.add(i);
        }
        
        k--;
        for(int i = 0; i<n;i++){
            // k-1을 (n-1)! 로 나눈 값
            long fact = factArray[n-i-1];
            int idx = (int) (k / fact); 
            
            k %= fact ;
            
            answer[i] = number.get(idx);    // 추가
            number.remove(idx);             // 삭제
        }
        
        return answer;
    }
}