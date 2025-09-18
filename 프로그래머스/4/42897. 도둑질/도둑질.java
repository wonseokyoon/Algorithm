import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;   // 집의 갯수
        
        if(n==1) return money[0];
        
        // 첫번째 집을 터는 경우(마지막 집 제외)
        int[] dp1 = new int[n];
        dp1[0] = money[0];
        dp1[1] = Math.max(money[0],money[1]);
        
        for(int i = 2; i < n-1; i++){
            // i번째 집을 털거나 or 털지 않거나
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
        }
        int max1 = dp1[n-2]; 
        
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = money[1];
        
        for(int i = 2; i < n; i ++){
            dp2[i] = Math.max(dp2[i-1],dp2[i-2] + money[i]);
        }
        int max2 = dp2[n-1]; 
        
        int answer = Math.max(max1,max2);
        return answer;
    }
}