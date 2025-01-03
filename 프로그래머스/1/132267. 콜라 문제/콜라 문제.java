class Solution {
    public int solution(int a, int b, int n) {
        int answer =0;
        while(n>=a){
            answer+=(n/a)*b;     // 6+2+1+0
            n=(n/a)*b+(n%a);     // 8 4 2 0
        }

        return answer;
    }
}