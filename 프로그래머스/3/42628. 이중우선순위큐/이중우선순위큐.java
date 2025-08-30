import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        // 오름차순 우선순위 큐
        PriorityQueue<Integer> ascPq = new PriorityQueue<>();
        // 내림차순 우선순위 큐
        PriorityQueue<Integer> descPq = new PriorityQueue<>((a,b) -> b-a);
        
        int size = 0;
        for(String operation: operations){
            String[] params = operation.split(" ");
            String command = params[0]; // 명령어
            String number = params[1];  // 숫자
            if(command.equals("I")){   // 삽입 명령어
                ascPq.offer(Integer.parseInt(number));
                descPq.offer(Integer.parseInt(number));
                size ++;
            } else {    // 삭제 명령어
                if(size > 0){
                    if(number.equals("-1")) {   // 최솟값 삭제
                        descPq.remove(ascPq.poll());
                        size --;
                    } else {        // 최댓값 삭제
                        ascPq.remove(descPq.poll());
                        size --;
                    }
                }
            }
        }
        if(size  == 0) return new int[]{0,0};
        return new int[]{descPq.poll(),ascPq.poll()};
    }
}