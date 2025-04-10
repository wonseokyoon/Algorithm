import java.util.*;
class Solution {
public int solution(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int cnt = 0;
        for(int i=0;i<len;i++){
            stack.clear();
            int index;
            for(int j=0;j<len;j++){
                // 인덱스
                index = (i+j) % len;
                char ch = chars[index];

                // 스택에 뭐가 들어있을때만
                if(!stack.isEmpty()){
                    // 쩍꿍찾기
                    if(ch == ']' && stack.peek() == '['){
                        stack.pop();
                    } else if(ch == '}' && stack.peek() == '{'){
                        stack.pop();
                    } else if(ch == ')' && stack.peek() == '(') {
                        stack.pop();
                    }
                    // 해당되는거 없어도 집어넣음: ),],}
                    else stack.push(ch);
                }
                // 스택이 비었으면 집어넣음
                else{
                    stack.push(ch);
                }
            }
            // 스택을 다 비웠으면
            if(stack.isEmpty()){
                cnt ++;
            }
        }

        return cnt;
    }

}