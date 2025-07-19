import java.util.*;
class Solution {
public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            answer[i] = -1;
        }

        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            // 스택이 비어있는 경우
            if(stack.isEmpty()) {
                stack.push(new int[]{i, num});  //  인덱스 번호와 원소 같이 저장: [0,2]
                continue;
            }

            int idx = stack.peek()[0];
            int peek = stack.peek()[1];

            // 스택이 비어있지 않고, 새로운 값이 더 큰 경우
            while (!stack.isEmpty() && peek < num){
                answer[idx] = num;     // num 저장
                stack.pop();
                if(!stack.isEmpty()) {
                    idx = stack.peek()[0];  // idx 업데이트
                    peek = stack.peek()[1]; // peek 업데이트
                }
            }

            stack.push(new int[]{i, num});
        }


        return answer;
    }
}