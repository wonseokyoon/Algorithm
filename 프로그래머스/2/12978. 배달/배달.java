import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        // [A마을,{B마을,거리}]
        Map<Integer,List<int[]>> map = new HashMap<>();        
        for(int i=1;i<=N;i++){
            map.put(i,new ArrayList<>());
        }
        
        for(int[] r:road){
            int townA = r[0];   // 출발 마을
            int townB = r[1];   // 도착 마을
            int distance = r[2];    // 거리
            
            // 양방향 등록
            map.get(townA).add(new int[]{townB,distance});
            map.get(townB).add(new int[]{townA,distance});
        }
        int[] distance = new int[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[1] = 0;
        
        // 거리 순 오름차순 정렬: {도착 마을,거리}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{1,0});   // 초기값
        
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int town = current[0];
            int cost = current[1];
            
            if(cost > distance[town]) {
                continue;
            }        
            
            for(int[] array: map.get(town)){
                int neighborTown = array[0];
                int neighborCost = array[1];
                
                // 새로운 코스트 
                int newCost = cost + neighborCost;
                
                if(newCost < distance[neighborTown]){
                    distance[neighborTown] = newCost;
                    pq.offer(new int[]{neighborTown,newCost});
                }
            }
        }
        
        int answer = 0;
        for(int i=1;i<=N;i++){
            if(distance[i] <= K) answer ++;
        }
        
        return answer;
        
    }
    
    
    
}