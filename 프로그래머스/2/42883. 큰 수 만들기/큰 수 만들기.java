import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        
        for(char numStr : number.toCharArray()) {
            int num = numStr - '0';
            
            while(!stack.isEmpty() && stack.peek() < num && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            if(k > 0) {
                stack.pop();
                k--;
            } else{
                sb.append(stack.pop());
            }
        }
        
        return sb.reverse().toString();
    }
}