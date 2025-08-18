import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    ArrayList<Integer>[] neighbours;
    public int solution(int n, int[][] wires) {
        neighbours = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            neighbours[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int tower1 = wire[0];
            int tower2 = wire[1];

            // 서로에게 연결된 송전탑 기록
            neighbours[tower1].add(tower2);
            neighbours[tower2].add(tower1);
        }

        int count = n;
        int diff = 0;
        int min = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            int tower1 = wire[0];
            int tower2 = wire[1];

            // 송전탑 사이를 끊으면 각자 갖는 연결된 송전탑 갯수
            count = bfs(tower1, tower2, n);
            diff = Math.abs(count - (n - count));
            min = Math.min(diff, min);
        }
        return min;
    }

    private int bfs(int tower1, int tower2, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(tower1);
        visited[tower1] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();     // 현재 탐색중인 타워

            for(int neighbour : neighbours[current]){
                if(!visited[neighbour] && neighbour != tower2){
                    visited[neighbour] = true;  // 방문 처리
                    queue.add(neighbour);   // 다음에 탐색할 송전탑
                    count++;    // 송전탑 개수
                }
            }
        }

        return count;
    }
}