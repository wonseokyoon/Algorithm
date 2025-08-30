import java.util.*;

class Solution {
    public long solution(int w, int h) {
        // 곱셈을 하기 전에 long으로 형변환하여 오버플로우를 방지합니다.
        long extent = (long) w * h;
        long gcd = GCD(w, h);      // 최대공약수
        long cnt = (long) w + h - gcd; // 가독성을 위해 (long)w 추가 (필수는 아님)

        return extent - cnt;
    }

    // 유클리드 호제법 (매우 효율적이며 올바르게 작성하셨습니다)
    long GCD(long num1, long num2){
        while(num2 != 0){
            long r = num1 % num2;
            num1 = num2;
            num2 = r;
        }
        return num1;
    }
}