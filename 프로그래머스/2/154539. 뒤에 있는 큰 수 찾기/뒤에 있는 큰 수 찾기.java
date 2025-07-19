import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);    // -1로 채움

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty()) {
                int idx = stack.peek();

                // 뒤의 수가 더 큰 경우
                if(numbers[idx] < numbers[i]) {
                    // 뒤의 값 저장
                    answer[idx] = numbers[i];
                    stack.pop();    // 기존 값 제거
                } else{
                    // 뒤의 값 푸시
                    stack.push(i);
                    break;
                }
            }
            stack.push(i);  // 새로운 값 추가

        }
        
        return answer;
    }
}