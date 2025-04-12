import java.util.*;
class Solution {
public int[] solution(int n, long left, long right) {
        List<Long> list = new ArrayList<>();
        boolean flag=false;
        long max;
        long start;
        if(left % n ==0){
            start = left / n -1;
        }else{
            start = left / n;
        }
        long cnt = start * n;
        for(long i=start;i<n;i++){
            for(long j=0;j<n;j++){
                max = Math.max(i,j) + 1;
                if(cnt >=left){
                    list.add(max);
                }
                cnt++;
                if(cnt >right) {
                    flag=true;
                    break;
                }
            }
            if(flag) break;
        }

        int[] answer = list.stream().mapToInt(Long::intValue).toArray();
        return answer;
    }
}