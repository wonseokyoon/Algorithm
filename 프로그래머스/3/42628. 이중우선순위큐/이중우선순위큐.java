import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 오름차순: 최솟값
        PriorityQueue<Integer> ascPq = new PriorityQueue<>();
        // 내림차순: 최댓값
        PriorityQueue<Integer> descPq = new PriorityQueue<>((a,b) -> b - a);
        
        int size = 0;
        for(String operation : operations){
            String commend = operation.split(" ")[0];
            int num = Integer.parseInt(operation.split(" ")[1]);
            
            if(commend.equals("I")){
                ascPq.offer(num);
                descPq.offer(num);
                size ++;
            } else{
                if(size > 0) {
                    if(num == -1) {  // 최솟값 삭제
                        descPq.remove(ascPq.poll());
                        size --;
                    } else {    // 최댓값 삭제
                        ascPq.remove(descPq.poll());
                        size --;
                    }
                }
            }
        }
        if(size > 0){
            return new int[] {descPq.poll(),ascPq.poll()};
        } else{
            return new int[] {0,0};
        }
    }
}