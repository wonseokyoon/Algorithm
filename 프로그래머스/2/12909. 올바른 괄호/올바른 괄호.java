import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        String str = s.substring(1,s.length());
        stack.push(s.charAt(0));
        
        for(char ch : str.toCharArray()){
            if(ch == ')'){
                if(!stack.isEmpty() && stack.pop() == '('){
                    continue;                    
                } 
                return false;
            }
            stack.push(ch);
        }
                

        return stack.isEmpty() ? true : false;
    }
}