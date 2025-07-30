import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer,Integer> visited = new HashMap<>();

        int cnt = 0;

        queue.offer(x);
        visited.put(x,cnt);     // 연산 횟수

        while (!queue.isEmpty()) {
            // 현 시점 x 값
            int cur = queue.poll();
            if(cur == y) return visited.get(cur);   // Y 도달 시 반환(너비우선 탐색이라 최소값 보장)

            // 3가지 연산
            int next1 = cur * 2;
            // 다음 수가 Y보다 작거나 같고, 방문한적 없는 숫자
            if(next1 <= y && !visited.containsKey(next1)){
                queue.offer(next1);
                visited.put(next1,visited.get(cur) + 1);      // 연산 횟수 증가
            }
            
            int next2 = cur * 3;
            if(next2 <= y && !visited.containsKey(next2)){
                queue.offer(next2);
                visited.put(next2, visited.get(cur) + 1);
            }

            int next3 = cur + n;
            if(next3 <= y && !visited.containsKey(next3)){
                queue.offer(next3);
                visited.put(next3, visited.get(cur) + 1);
            }

        }

        return -1;      // 도달 불가
    }
}