class Solution {
     public long solution(int price, int money, int count) {
        long sum=0;
        for(int i=1;i<=count;i++){
            sum+=price*i;
        }
     return Math.max(sum-money,0);  // 돈이 남으면 0, 돈이 모자라면 모자란 값 반환
    }
}
