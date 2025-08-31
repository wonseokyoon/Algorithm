import java.util.*;

class Solution {
    
    public int solution(int N, int number) {
        ArrayList<Set<Integer>> dp = new ArrayList<>();
        
        // 1~8까지만
        for(int i = 0; i < 9; i++){
            dp.add(new HashSet<>());
        }
        for(int i = 1; i < 9;i++){
            Set<Integer> currentSet = dp.get(i);
            
            StringBuilder stringBuilder = new StringBuilder();
            // N을 이어 붙이기
            for(int j = 0; j < i;j++){
                stringBuilder.append(N);
            }
           currentSet.add(Integer.parseInt(stringBuilder.toString()));
            
            // 사칙연산을 통해 추가
            for(int j = 1;j < i; j++){
                int k = i - j;
                
                Set<Integer> setK = dp.get(k);
                Set<Integer> setJ = dp.get(j);
                
                for(int num1 : setK){
                    for(int num2 : setJ) {
                        currentSet.add(num1 + num2);
                        currentSet.add(num1 - num2);
                        currentSet.add(num1 * num2);
                        if(num2 != 0){
                            currentSet.add(num1 / num2);
                        }
                    }
                }
            }
            
            // dp에서 number를 찾아서 반환
            if(currentSet.contains(number)){
                return i;
            }            
        }
        
        return -1;
    }
    
}