import java.util.*;
class Solution {
    class Task {
        private int idx;    // 작업 번호
        private int requiredTime;   // 요청 시간
        private int spendTime;    // 소요 시간
        
        public Task(int idx, int requiredTime, int spendTime){
            this.idx = idx;
            this.requiredTime = requiredTime;
            this.spendTime = spendTime;
        }
        
        @Override
        public String toString(){
            // return "[%d,%d,%d]".formatted(this.idx,this.requiredTime,this.spendTime);
            return "["+ this.idx + ","+ this.requiredTime + "," + this.spendTime +"]";
        }
    }
    
    public int solution(int[][] jobs) {
        Arrays.sort(jobs,(a,b) -> a[0] - b[0]);
        
        PriorityQueue<Task> waitQ = new PriorityQueue<>(new Comparator<Task>(){
            @Override
            public int compare(Task t1, Task t2){
                if(t1.spendTime == t2.spendTime){
                    if(t1.requiredTime == t2.requiredTime){
                        // 3. 작업 번호가 빠른거
                        return t1.idx - t2.idx;
                    }
                    // 2. 요청 시간이 빠른거
                    return t1.requiredTime - t2.requiredTime;
                }
                // 1. 소요시간이 짧은거
                return t1.spendTime - t2.spendTime;
            }
        });
        
        int currentTime = 0;
        int jobIdx = 0;
        int totalTime = 0;        
        int complete = 0;
        while(complete < jobs.length) {
            
            while(jobIdx < jobs.length && currentTime >= jobs[jobIdx][0]){
                int idx = jobIdx;
                int requiredTime = jobs[jobIdx][0];
                int spendTime = jobs[jobIdx][1];
                Task task = new Task(idx,requiredTime,spendTime);
                waitQ.offer(task);    // 대기 큐 등록
                jobIdx ++;
            }
            
            if(!waitQ.isEmpty()) {
                Task task = waitQ.poll();
                int spendTime = task.spendTime;
                int idx = task.idx;
                int requiredTime = task.requiredTime;
                
                complete++;     // 완료 처리
                currentTime += task.spendTime;  // 시간 갱신
                totalTime += currentTime - task.requiredTime;
            } else{
                currentTime = jobs[jobIdx][0];
            }
            
        }
        
        int answer = totalTime / complete;
        return answer;
    }
}