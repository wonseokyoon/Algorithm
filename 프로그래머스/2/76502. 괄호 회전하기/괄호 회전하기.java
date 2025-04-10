import java.util.*;
class Solution {
public int solution(String s) {

        int len = s.length();
        Queue<Character> queue = new LinkedList<>();
        for(char c : s.toCharArray()){
            queue.offer(c);
        }
        int cnt = 0;
        for(int i=0;i<len;i++){
            boolean flag = true;
            // quque의 사본
            Queue<Character> tempQue = new LinkedList<>(queue);
            for(int j=0; j<i; j++){
                // 맨 앞 꺼내서 맨 뒤로 집어넣음
                char temp = tempQue.poll();
                tempQue.offer(temp);
            }
            Stack<Character> tempStack = new Stack<>();

            for(int j=0; j<len; j++){
                char ch = tempQue.poll();
                if(ch == '[' || ch == '{' || ch == '('){
                    tempStack.push(ch);
                } else if (ch == ']') {
                    if(tempStack.isEmpty() || tempStack.pop() != '[') {
                        flag=false;
                        break;
                    }
                } else if(ch == '}'){
                    if(tempStack.isEmpty() || tempStack.pop() != '{') {
                        flag=false;
                        break;
                    }
                } else if(ch == ')'){
                    if(tempStack.isEmpty() || tempStack.pop() != '('){
                        flag=false;
                        break;
                    }
                }
            }           
            if(!tempStack.isEmpty()) flag=false;
            if(flag) cnt++;
        }
        return cnt;
    }

}