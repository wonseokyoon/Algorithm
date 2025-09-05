import java.util.*;

class Solution {
    public String solution(String number, int k) {
        char[] numberCh = number.toCharArray();
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < numberCh.length; i++) {
            int num = numberCh[i] - '0';
            
            while(!stack.isEmpty() && k > 0 && stack.peek() < num){
                stack.pop();
                k --;
            }
            
            stack.push(num);
        }
        
        while(k > 0){
            stack.pop();
            k --;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        String answer = sb.reverse().toString();
        
        return answer;
    }
}