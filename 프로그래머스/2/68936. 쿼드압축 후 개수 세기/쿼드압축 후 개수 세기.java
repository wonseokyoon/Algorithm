import java.util.Arrays;
class Solution {
    private int[] answer;

    public int[] solution(int[][] arr) {
        answer = new int[2];
        int n = arr.length;

        // (0,0) 부터 압축
        compress(arr, 0, 0, n);

        return answer;
    }

    private void compress(int[][] arr, int row, int col, int size) {
        // 압축 가능한지 체크
        if (isCompress(arr, row, col, size)) {
            int num = arr[row][col];    // 압축 할 값
            answer[num]++;      // 해당 값 증가
            return;
        }

        // 압축이 불가능
        int newSize = size / 2;   // 사이즈 절반 줄여서 재귀 호출

        compress(arr, row, col, newSize);       // 1번 영역
        compress(arr, row, col + newSize, newSize);     // 2번 영역
        compress(arr, row + newSize, col, newSize);     // 3번 영역
        compress(arr, row + newSize, col + newSize, newSize);       // 4번 영역
    }

    private boolean isCompress(int[][] arr, int row, int col, int size) {
        int prev = arr[row][col];   // 기준 값

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (prev != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}