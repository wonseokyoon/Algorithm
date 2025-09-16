import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> ascpq = new PriorityQueue<>();       // 오름차순(최솟값)
        PriorityQueue<Integer> descpq = new PriorityQueue<>((a,b) -> b - a);    // 내림차순(최댓값)
        
        int size = 0;
        for(String operation : operations) {
            String command = operation.split(" ")[0];
            String numStr = operation.split(" ")[1];
            int num = Integer.parseInt(numStr);
            
            if(command.equals("I")){
                ascpq.offer(num);
                descpq.offer(num);
                size ++;
            } else {
                if(size > 0) {
                    if(num == -1) { // 최솟값 삭제
                        descpq.remove(ascpq.poll());
                        size --;
                    } else {
                        ascpq.remove(descpq.poll());
                        size --;
                    }
                }
            }
        }
        
        if(size == 0) {
            return new int[] {0,0};
        }
        
        return new int[] {descpq.poll(), ascpq.poll()};
    }
}