class Solution {
    public long solution(long n) {
        double sq=Math.sqrt(n);
        if(sq%1==0){   //제곱근이 있는 경우
            return (long) Math.pow(sq+1,2);
        }
        else{
            return -1;
        }
    }
}