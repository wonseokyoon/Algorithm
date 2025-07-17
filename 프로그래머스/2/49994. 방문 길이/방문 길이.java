import java.util.*;
class Solution {
    public int solution(String dirs) {
        Map<String, Boolean> map = new HashMap<>(); // 방문한 지점 체크 <(0,0), false>
        int cnt = 0; // 횟수 카운팅

        // 초기값 세팅
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
        for(int i =0 ; i< dirs.length() ; i++) {
            switch(dirs.charAt(i)){
                case 'U':   // 상
                    endX = startX;
                    endY = startY+1;
                    break;
                case 'D':   // 하
                    endX = startX;
                    endY = startY-1;
                    break;
                case 'L':   // 좌
                    endX = startX-1;
                    endY = startY;
                    break;
                case 'R':   // 우
                    endX = startX+1;
                    endY = startY;
                    break;
            }
            // 범위 체크
            if(endX <-5 || endY <-5 || endX > 5 || endY > 5) continue;
            
            // 시작과 종료 좌표 등록
            String start = startX+","+startY;
            String end = endX+","+endY;

            // 좌표를 이용해서 경로 등록(양방향 체크)
            String path1 = start + "->" + end;
            String path2 = end + "->" + start;

            // 초행길 체크
            if(!map.containsKey(path1) && !map.containsKey(path2)) {
                map.put(path1, true);
                map.put(path2, true);
                cnt++;
            }

            // 현재 위치 업데이트
            startX = endX;
            startY = endY;
        }

        return cnt;
    }

}