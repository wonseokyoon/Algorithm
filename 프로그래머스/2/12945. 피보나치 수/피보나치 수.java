class Solution {
    public int solution(int n) {
        int answer = fibo(n);
        return answer;
    }

    public int fibo(int num) {
        if(num == 0) return 0;
        if(num == 1) return 1;

        int[] fib = new int[num + 1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2; i <= num; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % 1234567;
        }
        return fib[num];
    }
}