import java.util.Arrays;

class Solution {
public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = -1;
            }
            total += (i + 1);
        }
        int num = 1;

        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        int direction = 0;
        int x = -1;
        int y = 0;
        while (num <= total) {

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx >= 0 && nx < n && ny >= 0 && ny <= nx && triangle[nx][ny] == -1) {
                x=nx;
                y=ny;
                triangle[nx][ny] = num++;
            }else{
                // 방향 전환
                direction = (direction + 1) % 3;
            }
        }
        int[] result = new int[total];
        int index = 0;
        for(int i = 0; i < triangle.length; i++) {
            for(int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }
        return result;
    }
}