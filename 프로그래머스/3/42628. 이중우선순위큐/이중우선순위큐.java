import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> apq = new PriorityQueue<>();     // 오름차순
        PriorityQueue<Integer> dpq = new PriorityQueue<>((a,b) -> b - a);   // 내림차순
        
        int size = 0;
        
        for(String operation : operations){
            String command = operation.split(" ")[0];
            String numStr = operation.split(" ")[1];
            
            if(command.equals("I")){
                int num = Integer.parseInt(numStr);
                apq.offer(num);
                dpq.offer(num);
                size ++;
            } else{
                if(size > 0){
                    if(numStr.equals("-1")) {  // 최솟값 삭제
                        size --;
                        dpq.remove(apq.poll());
                    } else { // 최댓값 삭제
                        size --;
                        apq.remove(dpq.poll());
                    }
                }
            }
        }
        if(size == 0) return new int[] {0,0};        
        return new int[] {dpq.poll(), apq.poll()};
    }
}