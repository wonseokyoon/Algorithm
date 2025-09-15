import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        
        int complete = 0;
        for(char ch : number.toCharArray()) {
            int num = ch -'0';
            
            while(!stack.isEmpty()) {
                if(stack.peek() < num && complete < k){
                    stack.pop();
                    complete++;
                } else break;
            }
            stack.push(num);
        }
        
        StringBuilder sb = new StringBuilder();
        while(complete < k) {
            stack.pop();
            complete++;
        }
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }
}