import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        boolean[] paint=new boolean[n+1];
        int cnt=0;
        Arrays.fill(paint,true);
        for(int digit:section){
            paint[digit]=false;
        }
        // false인 부분만 true로 채우면 됨

        for(int i=section[0];i<=n;i++){
            if(!paint[i]){  //안칠해져있으면
                for(int j=i;j<i+m;j++){
                    if(j>n) break;  //인덱스 범위 안벗어나게
                    paint[j]=true;
                }
                cnt++;
            }
        }
        return cnt;
    }
}