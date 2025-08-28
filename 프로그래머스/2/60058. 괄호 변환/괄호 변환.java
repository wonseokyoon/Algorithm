import java.util.*;

class Solution {
    int lCnt;
    int rCnt;
    String answer = "";
    String temp = "";
    public String solution(String p) {
        return recursion(p);
    }
    
    String recursion(String p){
        if(p.length() == 0) return "";
        
        String u =  separationUV(p)[0];
        String v =  separationUV(p)[1];
        if(isCorrect(u)) {  // u가 올바른 문자열
            return u + recursion(v);
        } else{
            // 올바른 문자열이 아닌 경우
            v = "(" + recursion(v)+ ")";
            u = u.substring(1,u.length()-1);    // 양 끝 문자 제거
            u = reverse(u);
            return v+u;
        }
    }
    
    String reverse(String u){
        if(u.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(char ch : u.toCharArray()){
            if(ch == '(') sb.append(')');
            else sb.append('(');
        }
        return sb.toString();
    }
    
    String[] separationUV(String p){
        lCnt =0;
        rCnt =0;
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        for(char ch : p.toCharArray()){
            // 균형 잡힌 괄호 문자열 완성
            if(lCnt != 0 && lCnt == rCnt){
              v.append(ch);  
            } else{
                if(ch == '(') {
                    lCnt++;
                    u.append(ch);
                } else {
                    rCnt++;
                    u.append(ch);
                }    
            }
        }
        
        return new String[]{u.toString(),v.toString()};
    }
    
    boolean isCorrect(String u) {
        if(lCnt == rCnt && lCnt != 0) {     // 균형이 맞고
            Stack<Character> stack = new Stack<>();
            for(char ch : u.toCharArray()){
                if(ch =='('){
                    stack.push(ch);
                } else{
                    // ')' 와의 짝인 '('이 stack에 있으면
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                        continue;
                    }
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}