import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    ArrayList<HashSet<Integer>> dp = new ArrayList<>();
    
    public int solution(int N, int number) {
        
        for(int i = 0; i< 9; i++){
            dp.add(new HashSet<>());            
        }
        
        for(int i = 1; i< 9; i++){
            Set<Integer> currentSet = dp.get(i);
            
            StringBuilder sb = new StringBuilder();
            
            // 이어 붙이기
            for(int j = 0; j < i; j++){
                sb.append(N);
            }
            currentSet.add(Integer.parseInt(sb.toString()));
            
            // 사칙연산
            for(int j = 0; j < i; j++){
                Set<Integer> setJ = dp.get(j);
                Set<Integer> setK = dp.get(i-j);
                
                for(int num1 : setJ){
                    for(int num2 : setK){
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