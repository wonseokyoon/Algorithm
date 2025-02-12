import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int row = park.length;    // 행
        int col = park[0].length; // 열
        Arrays.sort(mats); // 돗자리 크기를 오름차순으로 정렬
        int answer = -1; // 깔 수 있는 최대 크기

        // 돗자리 크기 확인
        for (int size : mats) {
            boolean canPlace = false; // 현재 돗자리를 놓을 수 있는지 여부

            // 공간을 별도로 탐색
            for (int i = 0; i <= row - size; i++) { // 행 경계
                for (int j = 0; j <= col - size; j++) { // 열 경계
                    boolean isAvailable = true; // 해당 위치가 비어 있는지 확인
                    
                    // 주어진 크기에서 모든 공간 체크
                    for (int r = i; r < i + size; r++) {
                        for (int c = j; c < j + size; c++) {
                            if (!park[r][c].equals("-1")) { // 다른 사람이 있는 경우
                                isAvailable = false;
                                break;
                            }
                        }
                        if (!isAvailable) break; // 더 이상 확인할 필요 없음
                    }

                    // 비어 있는 경우
                    if (isAvailable) {
                        canPlace = true; // 현재 크기의 돗자리를 놓을 수 있는 상태
                        break;
                    }
                }
                if (canPlace) break; // 더 이상 반복할 필요 없음
            }

            // 최대 크기 업데이트
            if (canPlace) {
                answer = size; // 가능한 가장 큰 돗자리를 할당
            }
        }

        return answer; // 결과 반환
    }
}