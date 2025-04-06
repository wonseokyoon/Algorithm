class Solution {
        public int solution(int[] arr) {
        int answer = arr[0];
        for(int i=1;i<arr.length;i++){
            answer = lcm(arr[i], answer);
        }

        return answer;
    }

    // 최소공배수
    public int lcm(int a, int b) {
        int gcd = gcd(a,b);
        a = a / gcd;
        b = b / gcd;
        return a * b * gcd;
    }

    // 최대공약수
    public int gcd(int a, int b) {
        while(b>0){
            int temp = a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}