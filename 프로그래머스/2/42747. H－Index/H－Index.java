import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // n편의 논문 중, h번 이상 인용된 논문이 h 이상, 나머지 논문이 h번 이하 인용되었다면 h의 최댓값: h-index
        
        int[] sorted = Arrays.stream(citations)
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
        System.out.println(Arrays.toString(sorted));
        
        int len = citations.length;     // 길이
        int hIdx = sorted[0];      // 최댓값으로 초기값 설정
        int max = 0;
        while(hIdx > 0) {
            int cnt = 0;    // h번 이상 인용된 논문 갯수
            for(int i = 0; i < len; i++){
                if(sorted[i] >= hIdx) {
                    cnt ++;
                } else{
                    break;
                }
            }
            if(cnt >= hIdx) return hIdx;
            else{
                hIdx --;
            }
        }
        return 0;
    }
}