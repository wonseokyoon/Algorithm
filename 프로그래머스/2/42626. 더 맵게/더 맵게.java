import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 맵기를 기준으로 오름차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a - b);
        
        for(int s : scoville){
            pq.offer(s);
        }
        
        int answer = 0;
        // 모든 음식이 K를 넘을때까지 반복
        while(pq.peek() < K && pq.size() > 1) {
            int k1 = pq.poll();
            int k2 = pq.poll();
            
            int newK = k1 + (k2 * 2);
            answer ++;          // 횟수 추가
            pq.offer(newK);     // 새로 만든 맵기 추가
        }
        
        if(pq.peek() < K) { // 못만든 경우
            return -1;
        } else{
            return answer;
        }
    }
}