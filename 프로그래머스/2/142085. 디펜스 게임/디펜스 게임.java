import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        // 우선 순위 큐 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt =0;
        for(int number : enemy){
            // 일단 무적권 사용 가정
            pq.offer(number);
            
            // 무적권 횟수 초과 사용
            if(pq.size() > k) {
                int min = pq.poll();    // 지금까지 사용한 무적권에서 가장 적은 수
                n-=min;                 // 이건 직접 막음
            }
            if(n<0) return cnt;     // 못막아
            cnt++;
        }
        
        return enemy.length;
    }
}