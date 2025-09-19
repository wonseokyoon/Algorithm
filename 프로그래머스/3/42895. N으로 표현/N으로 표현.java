import java.util.*;

class Solution {
    ArrayList<HashSet<Integer>> dp = new ArrayList<>();
    
    public int solution(int N, int number) {
        if(N == number) return 1;
        // 빈 리스트 생성
        for(int i = 0; i <= 8; i++){
            dp.add(new HashSet<Integer>());
        }
        
        // 이어 붙이기
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 8; i++) {
            sb.append(N);
            dp.get(i).add(Integer.parseInt(sb.toString()));
        }
        
        // 사칙 연산
        for(int i = 2; i <= 8; i++) {
            HashSet<Integer> currentSet = dp.get(i);
            
            for(int j = 1; j < i; j++) {
                int k = i - j;
                HashSet<Integer> setJ = dp.get(j);
                HashSet<Integer> setK = dp.get(k);
                
                for(Integer num1 : setJ) {
                    for(Integer num2 : setK) {
                        currentSet.add(num1 + num2);
                        currentSet.add(num1 - num2);
                        currentSet.add(num1 * num2);
                        if(num2 != 0) currentSet.add(num1 / num2);
                    }
                }
            }
            
            if(currentSet.contains(number)) return i;
        }
        
        return -1;
    }
}