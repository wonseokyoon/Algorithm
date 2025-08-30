import java.util.*;
import java.math.BigInteger;

class Solution {
    public long solution(int w, int h) {
        long extent = (long) w * h;
        BigInteger bigW = BigInteger.valueOf(w);
        BigInteger bigH = BigInteger.valueOf(h);
        long gcd = bigW.gcd(bigH).longValue();
        long cnt = w + h - gcd;
        return extent - cnt;        
    }
    
}