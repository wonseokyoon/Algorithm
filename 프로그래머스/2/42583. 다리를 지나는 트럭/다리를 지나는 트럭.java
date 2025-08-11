import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int idx = 0;
        while(idx < truck_weights.length){
            if(queue.isEmpty()){
                queue.add(truck_weights[idx++]);
                time++;
                continue;
            }

            // 다리 길이보다 짧을 경우
            if(queue.size() < bridge_length){
                // 큐의 합
                long current = queue.stream()
                        .mapToLong(Integer::longValue)
                        .sum();

                // 하중 초과
                if(current + truck_weights[idx] > weight){
                    queue.offer(0);     // 다리의 시간 흐름 체크를 위해 빈 공간 추가
                    time++;
                }else{
                    queue.add(truck_weights[idx++]);
                    time++;
                }
            } else if (queue.size() == bridge_length) {
                queue.poll();   // 내림

                long current = queue.stream()
                        .mapToLong(Integer::longValue)
                        .sum();
                if(current + truck_weights[idx] > weight){
                    queue.offer(0);
                    time++;
                }else{
                    queue.add(truck_weights[idx++]);
                    time++;
                }
            }
        }


        return time + bridge_length;
    }
}