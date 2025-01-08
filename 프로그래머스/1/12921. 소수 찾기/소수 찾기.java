import java.util.*;
class Solution {
    public int solution(int n) {
        int cnt=0;
        if(n<2) return 0;

        boolean[] isprime=new boolean[n+1];
        Arrays.fill(isprime,true);
        isprime[0]=false;
        isprime[1]=false;
        
        for(int i=4;i<=n;i+=2){ //짝수 제외
            isprime[i]=false;
        }

        for(int i=3;i<=n;i+=2){ 
            for(int j=2;j*j<=i;j++){
                if(i%j==0){
                isprime[i]=false;
                break;
                }
            }
        }

        for(boolean bool:isprime){
            if(bool) cnt++;
        }
        return cnt;

    }
}