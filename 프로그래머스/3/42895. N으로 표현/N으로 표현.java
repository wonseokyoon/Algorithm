import java.util.*;

class Solution {
    
    public int solution(int N, int number) {
        ArrayList<HashSet<Integer>> dp = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < 9; i ++) {
            dp.add(new HashSet<>());            
        }
        
        for(int i = 1; i < 9; i++){
            HashSet<Integer> currentSet = dp.get(i);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < i; j ++){
                sb.append(N);
            }
            
            currentSet.add(Integer.parseInt(sb.toString()));
            
            // 사칙연산
            for(int j = 1; j < i; j++) {
                HashSet<Integer> setJ = dp.get(j);
                HashSet<Integer> setK = dp.get(i-j);
                
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