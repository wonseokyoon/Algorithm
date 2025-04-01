class Solution {
    
    public int solution(int n) {
        int cnt =1 ;
        for(int i = 1; i < n; i++) {
            int sum = 0;
            int j = i;
            while(sum < n){
                sum += j ++;
                if(sum == n){
                    cnt ++;
                }
            }

        }

        return cnt;
    }
}