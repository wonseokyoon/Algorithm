import java.util.*;
class Solution {
    public int solution(int n) {
        int cnt=0;
        if(n<2) return 0;

        boolean[] isprime=new boolean[n+1];
        Arrays.fill(isprime,true);
        isprime[0]=false;
        isprime[1]=false;

        for(int i=2;i<=n;i++){
            if(isprime[i]){ // 소수의 배수도 지움
                for(int j=i*2;j<=n;j+=i){
                    isprime[j]=false;
                }
            }
        }
        for(boolean bool:isprime){
            if(bool) cnt++;
        }
        return cnt;

    }
}