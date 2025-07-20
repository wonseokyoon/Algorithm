import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> scovilleHeap = new PriorityQueue<>();
        
        for(int num : scoville){
            scovilleHeap.offer(num);
        }

        int count = 0;

        while (scovilleHeap.size() > 1) {
            // 모든 스코빌 지수가 K 이상이면
            if(scovilleHeap.peek() >= K) break;

            // 맨 앞 두개 원소 꺼내서 계산
            int newScoville = scovilleHeap.poll() + scovilleHeap.poll() * 2;

            // 새로운 인덱스 삽입
            scovilleHeap.offer(newScoville);

            count++;
        }

        if(scovilleHeap.peek() >= K) return count;
        return -1;
    }

}