import java.util.*;
class Solution {
    public int solution(int[] order) {
        Queue<Integer> box = new PriorityQueue<>(); // 택배 박스
        Stack<Integer> assist = new Stack<>();  // 보조 벨트

        for(int i = 1; i <= order.length; i++){
            box.add(i);     // 1,2,3,4,...
        }

        int cnt = 0;    // 갯수 카운트
        int idx = 0;    // order 인덱스 추적
        // 박스를 전부 비울때까지
        while(!box.isEmpty() || !assist.isEmpty()){

            // 박스의 값이 order 와 일치 할 경우
            if(!box.isEmpty() && box.peek() == order[idx]){
                // 카운팅하고 다음 인덱스로
                box.poll();
                cnt++;
                idx++;

                // order 와 보조 벨트의 값과 일치 할 경우
            } else if (!assist.isEmpty() && assist.peek() == order[idx]) {
                cnt++;
                idx++;
                assist.pop();

                // order 와 보조 벨트 값이 다른 경우
            } else if (!box.isEmpty()) {
                // 보조 벨트에 푸시
                assist.push(box.poll());

                // 종료
            } else break;
        }

        return cnt;
    }
}