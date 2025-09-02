import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> readyQueue = new LinkedList<>();
        // [무게,경과시간]
        Queue<int[]> bridgeQueue = new LinkedList<>();
        for(int truck :truck_weights){
            readyQueue.offer(truck);
        }
        
        int weightSum = 0;
        int currentTime = 0;
        int startTime;
        while(!readyQueue.isEmpty()){
            currentTime ++;
            int truck = readyQueue.peek();
            if(!bridgeQueue.isEmpty()){
                startTime = bridgeQueue.peek()[1];  // 다리에 올라간 시간
                if(currentTime - startTime == bridge_length){
                    // 완전히 다리에서 내려감
                    weightSum -= bridgeQueue.poll()[0];             
                }
            }
            
            if(truck + weightSum <= weight){
                bridgeQueue.offer(new int[]{truck,currentTime});   // 다리에 올림
                weightSum+=truck;           // 무게 추가
                readyQueue.poll();
            }
        }
        
        return currentTime + bridge_length;
    }
}