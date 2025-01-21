import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] x={0,0,0,0,0,0,0,0,0,0};
        int[] y={0,0,0,0,0,0,0,0,0,0};
        for(char ch:X.toCharArray()){
            x[ch-'0']++;
        }
        for(char ch:Y.toCharArray()){
            y[ch-'0']++;
        }
        // 2 1 0 0 0 0 0 ...
        // 2 0 1 1 1 1 0 ...
        StringBuilder sb=new StringBuilder();
        for(int i=9;i>=0;i--){
            int cnt=Math.min(x[i],y[i]);
            for(int j=0;j<cnt;j++){
                sb.append(i);
            }
        }
        if(sb.length()==0) return "-1";
        if(sb.toString().charAt(0)=='0') return "0";
        return sb.toString();

    }
}