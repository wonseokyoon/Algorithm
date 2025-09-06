import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int len = citations.length;
        
        int[] sorted = Arrays.stream(citations)
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
        
        System.out.println(Arrays.toString(sorted));
        
        int h = sorted[0];
        while(h > 0){
            int cnt = 0;
            for(int i = 0; i < len; i++){
                if(sorted[i] >= h) cnt ++;
                else break;
            }
            
            if(cnt >= h) return h;
            else{
                h--;
            }
        }
        
        int answer = 0;
        return answer;
    }
}