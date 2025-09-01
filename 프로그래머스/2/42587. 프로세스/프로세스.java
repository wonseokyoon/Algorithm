import java.util.*;
class Solution {
    class Status {
        int priority;
        int location;
        
        public Status(int priority, int location){
            this.priority = priority;
            this.location = location;
        }
        
        @Override
        public String toString(){
            return "[" + priority + "," + location +"]";
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Status> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int i = 0;
        for(int priority : priorities){
            Status status = new Status(priority,i++);
            queue.offer(status);
            list.add(priority);
        }
        
        // 정렬
        Collections.sort(list,Collections.reverseOrder());
        
        int cnt = 1;
        while(!queue.isEmpty()){
            Status status = queue.poll();
            int priority = status.priority;
            int idx = status.location;
            int target = list.get(0);
            
            if(target == priority) {
                list.remove(0);    // 삭제
                if(location == idx) return cnt;
                cnt ++;
            } else{
                queue.offer(status);
            }
        }
        
        
        int answer = 0;
        return answer;
    }
}