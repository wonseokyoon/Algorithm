import java.util.Stack;
class Solution {
    boolean solution(String s) {
        Stack stack = new Stack();
        char[] chars= new char[s.length()];
        for(int i=0; i<s.length();i++){
            chars[i]=s.charAt(i);
        }

        for(char c:chars){
            if(c == '('){
                stack.push(c);
            }else {
                if(stack.size()==0){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }


        if(stack.empty()) return true;
        return false;
    }
}