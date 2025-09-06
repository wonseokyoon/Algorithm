import java.util.*;

class Solution {
    class Task {
        private int requiredTime;
        private int spendTime;
        private int idx;
        
        public Task(int requiredTime, int spendTime, int idx) {
            this.requiredTime = requiredTime;
            this.spendTime = spendTime;
            this.idx = idx;
        }
    }
    
    public int solution(int[][] jobs) {
        // jobs 정렬
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        // 1. 소요시간 짧은거, 요청 빨리한거
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b) -> {
            if(a.spendTime == b.spendTime){
                if(a.requiredTime == b.requiredTime){
                    return a.idx - b.idx;
                }
                return a.requiredTime - b.requiredTime;  
            }
            return a.spendTime - b.spendTime;  
        });
        
        int currentTime = 0;    // 현재 시간
        int totalTime = 0;  // 총 작업 시간
        int complete = 0;   // 작업 완료 갯수
        int cnt = jobs.length;  // 작업 갯수
        int jobIdx = 0;         // 작업 번호
        
        // 모든 작업이 완료될때까지 반복
        while(complete < cnt) {
            
            while(jobIdx < cnt && currentTime >= jobs[jobIdx][0]) {
                // 큐에 작업 추가
                int requiredTime = jobs[jobIdx][0];
                int spendTime = jobs[jobIdx][1];
                Task task = new Task(requiredTime,spendTime,jobIdx);
                pq.offer(task);
                jobIdx++;
            }
            
            // 동록된 작업 처리
            if(!pq.isEmpty()) {
                Task task = pq.poll();
                int requiredTime = task.requiredTime;
                int spendTime = task.spendTime;
                
                currentTime += spendTime;
                complete ++;
                totalTime += (currentTime - requiredTime);
            } else{
                currentTime = jobs[jobIdx][0];
            }
        }
        
        return totalTime / complete;
    }
}