import java.util.*;

public class Solution {
    public int solution(int n) {
        int cnt =0;
        while(n>0) {
            if (isEven(n)) {
                n/=2;
            }else {
                n--;
                cnt ++;
            }
        }
        return cnt;
    }

    private boolean isEven(int n) {
        return n%2==0;
    }
}