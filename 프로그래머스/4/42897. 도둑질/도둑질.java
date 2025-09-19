import java.util.*;

class Solution {
    public int solution(int[] money) {
        // 1번 집을 털 경우 -> 마지막 집 못텀
        // 1번 집을 안 털 경우 -> 마지막 집 털 수 있음
        int length = money.length;
        if(length == 1) return money[0];
        
        int[] maxDp1 = new int[length];
        int[] maxDp2 = new int[length];
        
        maxDp1[0] = money[0];
        maxDp1[1] = Math.max(money[0],money[1]);
        
        for(int i=2; i < length - 1; i++) {
            maxDp1[i] = Math.max(maxDp1[i-2] + money[i], maxDp1[i-1]);
        }
        
        maxDp2[0] = 0;
        maxDp2[1] = money[1];
        
        for(int i=2; i < length; i ++){
            maxDp2[i] = Math.max(maxDp2[i-2] + money[i], maxDp2[i-1]);
        }
        
        int answer = Math.max(maxDp1[length-2],maxDp2[length-1]);
        return answer;
    }
}