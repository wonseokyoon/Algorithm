import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for(char num : number.toCharArray()) {
            // 뒤에 숫자가 더 큰 경우
            while(!stack.empty() && k > 0 && stack.peek() < num){
                stack.pop();
                k--;
            }
            stack.push(num);
        }

        // k가 남아있다면 뒤에서부터 삭제
        while(k>0){
            stack.pop();
            k--;
        }

        StringBuilder answer = new StringBuilder();

        for(Character c : stack) {
            answer.append(c);
        }

        return answer.toString();
    }
}