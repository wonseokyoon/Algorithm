import java.util.*;

class Solution {
    class Task {
        private int idx;
        private int requiredTime;
        private int spendTime;
        
        public Task(int idx, int requiredTime, int spendTime){
            this.idx = idx;
            this.requiredTime = requiredTime;
            this.spendTime = spendTime;
        }
    }
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<Task> waitQ = new PriorityQueue<>(new Comparator<Task>(){
            @Override
            public int compare(Task t1, Task t2){
                if(t1.spendTime == t2.spendTime){
                    if(t1.requiredTime == t2.requiredTime){
                        return t1.idx - t2.idx;  
                    }
                    return t1.requiredTime - t2.requiredTime;
                }
                return t1.spendTime - t2.spendTime;
            }
        }); 
        
        int complete = 0; 
        int currentTime = 0;
        int jobIdx = 0;
        int cnt = jobs.length;
        int totalTime = 0;
        while(complete < cnt) {
            
            while(jobIdx < cnt && jobs[jobIdx][0] <= currentTime){
                int requiredTime = jobs[jobIdx][0];
                int spendTime = jobs[jobIdx][1];
                
                Task task = new Task(jobIdx++, requiredTime, spendTime);
                waitQ.offer(task);
            }
            
            if(!waitQ.isEmpty()){
                Task task = waitQ.poll();
                
                int requiredTime = task.requiredTime;
                int spendTime = task.spendTime;
                int idx = task.idx;
                
                currentTime += spendTime;
                totalTime += currentTime - requiredTime;
                complete++;
            } else{
                currentTime = jobs[jobIdx][0];
            }
        }
        
        return totalTime/cnt;
    }
}