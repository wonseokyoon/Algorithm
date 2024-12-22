class Solution {
    public int solution(int num) {
        long n=num;
        if(n==1) return 0;
        for(int i=0;i<500;i++){
            n=(n%2==0)?n/2:n*3+1;
            if(n==1) return i+1;
        }
        return -1;

    }
}