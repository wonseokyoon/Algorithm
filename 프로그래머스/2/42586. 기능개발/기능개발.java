import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i< speeds.length; i++){
            int progress = progresses[i];
            int speed = speeds[i];
            
            int day = 0;
            while(progress < 100){
                progress += speed;
                day ++;
            }
            queue.offer(day);
        }
        
        List<Integer> answer = new ArrayList<>();
        int standard = queue.poll(); // 기준 값
        int cnt = 1;
        while(!queue.isEmpty()){
            if(standard < queue.peek()) {
                standard = queue.poll();
                answer.add(cnt);
                cnt = 1;    // cnt 초기화
            } else{
                queue.poll();
                cnt ++;
            }            
        }
        answer.add(cnt);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}