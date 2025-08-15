class Solution {
    public int solution(int storey) {
        int cnt = 0;
        while (storey > 0) {
            int digit = storey % 10;    // 현재 자리
            int nextDigit = (storey % 100) / 10;    // 다음 자리

            if (digit > 5 || digit == 5 && nextDigit >= 5) {  // 올림
                cnt += 10 - digit;
                storey += 10;
            } else {     // 내림
                cnt += digit;
            }
            storey /= 10;
        }

        return cnt;
    }
}