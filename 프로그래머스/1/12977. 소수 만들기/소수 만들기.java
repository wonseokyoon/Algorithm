import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int cnt=0;
        for(int i=0;i< nums.length;i++){
            int sum=0;
            for (int j=i+1;j<nums.length;j++){
                for (int k=j+1;k< nums.length;k++){
                    sum=nums[i]+nums[j]+nums[k];
                    if(isPrime(sum)) cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean isPrime(int n) {
        if(n<2) return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;

    }

}