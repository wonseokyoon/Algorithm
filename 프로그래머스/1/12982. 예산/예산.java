import java.util.Arrays;
class Solution {
    public int solution(int[] d, long budget) {
        Arrays.sort(d);
        long remain = budget;  //남은 돈
        int cnt=0;
        for (int i = 0; i < d.length; i++) {
            remain-=d[i];
            if(remain<0) return cnt;
            cnt++;
        }
        return cnt;
    }
}