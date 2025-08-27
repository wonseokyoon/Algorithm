import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemies) {
        // 우선순위 큐를 사용하여 무적권 사용 컨트롤
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int round = 0;
        for(int enemy:enemies){
            // 무적권 사용해서 막았다고 가정
            pq.offer(enemy);
            
            // 무적권 사용 횟수 초과 -> 최소 침입은 몸빵
            if(pq.size() > k){
                int minNumber = pq.poll();
                n-=minNumber;
            }
            
            // 못막아
            if(n < 0) return round;
            
            round++;
        }
        
        return enemies.length;
    }
}