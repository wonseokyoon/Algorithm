import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;       // 맵의 행 수
        int m = maps[0].length;    // 맵의 열 수

        // 방향 벡터 (상, 하, 좌, 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 거리 저장 배열: 시작점 (0,0)에서 부터 거리 1부터 시작
        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], 0);
        }
        // BFS용 큐
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        distance[0][0] = 1;  // 시작 지점 거리 1로 세팅

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            // 목적지에 도달하면 거리 반환
            if (x == n - 1 && y == m - 1) {
                return distance[x][y];
            }

            // 네 방향 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 맵 범위 내이고, 방문하지 않았으며, 길(1)인 경우
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (maps[nx][ny] == 1 && distance[nx][ny] == 0) {
                        distance[nx][ny] = distance[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        // 도달 못하는 경우
        return -1;
    }
}