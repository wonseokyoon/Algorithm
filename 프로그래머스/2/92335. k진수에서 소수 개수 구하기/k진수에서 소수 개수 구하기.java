import java.util.*;
class Solution {
    public int solution(int n, int k) {
        // n -> k 진수로 변환
        String decimal = Integer.toString(n,k);

        // 0을 기준으로 split
        String[] strs = Arrays.stream(decimal.split("0"))
                .filter(str -> !str.isEmpty())  // 공백 문자 제거
                .toArray(String[]::new);

        int cnt = 0;
        // 소수인지 체크
        for(String str : strs){
            Long num = Long.parseLong(str);
            if(isPrime(num)) cnt++;
        }

        return cnt;
    }

    private boolean isPrime(Long num) {
        if(num < 2) return false;

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }

        return true;
    }

}