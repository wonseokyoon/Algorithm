import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());    // 우선순위 큐(역순)
        int cnt = 0;
        for(int num : priorities){
            pq.add(num);    // 큐에 값 등록
        }

        while (!pq.isEmpty()) {
            for(int i=0; i<priorities.length;i++){
                if(pq.peek() == priorities[i]){
                    pq.poll();
                    cnt++;

                    if(location == i){
                        return cnt;
                    }
                }
            }
        }
        return cnt;
    }
}