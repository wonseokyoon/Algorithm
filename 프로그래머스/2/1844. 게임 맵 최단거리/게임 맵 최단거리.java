import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int xLength = maps.length;   // x축 길이
        int yLength = maps[0].length;      // y축 길이

        int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};     // 이동(상하좌우)
        int[][] distance = new int[xLength][yLength];   // 거리 좌표

        // 좌표 큐
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        distance[0][0] = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();   // 현재 좌표
            int x = cur[0];
            int y = cur[1];

            if(x == xLength-1 && y == yLength-1) return distance[x][y];

            for(int i = 0; i < 4; i++){
                int dx = x + move[i][0];   // 이동 후 x좌표
                int dy = y + move[i][1];   // 이동 후 y좌표


                // 범위 체크
                if(dx >= 0 && dy >= 0 && dx < xLength && dy < yLength){
                    // 방문 체크 + 길인지 체크
                    if(maps[dx][dy] == 1 && distance[dx][dy] == 0){
                        queue.add(new int[]{dx,dy});    // 큐 등록
                        distance[dx][dy] = distance[x][y] + 1;      // 이전 좌표 +1
                    }
                }
            }
        }
        return -1;  // 도달 못하는 경우
    }
}