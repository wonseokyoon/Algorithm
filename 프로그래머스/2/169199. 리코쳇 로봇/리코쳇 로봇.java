import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};  // 상하좌우 이동을 위한 배열
    int[] dy = {0, 0, -1, 1};
    int n, m;  // 보드의 크기

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        int[] start = new int[2];
        int[] goal = new int[2];

        // 시작 위치와 목표 위치 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                } else if (board[i].charAt(j) == 'G') {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }

        return bfs(board, start, goal);
    }

    private int bfs(String[] board, int[] start, int[] goal) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(new int[]{start[0], start[1], 0});  // x, y, 이동 횟수
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], moves = current[2];

            if (x == goal[0] && y == goal[1]) {
                return moves;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x, ny = y;
                // 해당 방향으로 끝까지 이동
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx].charAt(ny) != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                // 벽이나 장애물 직전 위치로 이동
                nx -= dx[i];
                ny -= dy[i];

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, moves + 1});
                }
            }
        }

        return -1;  // 목표에 도달할 수 없는 경우
    }
}