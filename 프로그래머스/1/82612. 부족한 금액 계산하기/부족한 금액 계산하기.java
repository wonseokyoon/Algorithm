class Solution {
    public long solution(int price, int money, int count) {
        long sum=0;
        for(int i=1;i<=count;i++){
            sum+=price*i;
        }
        // 3, 3+6=9, 3+6+9=18, 3+6+9+12=30
        return Math.max(sum-money,0);
    }
}