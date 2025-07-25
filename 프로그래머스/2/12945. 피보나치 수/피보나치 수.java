class Solution {
        public int solution(int n) {
        int answer = 0;
        long[] pib=new long[n+1];
        pib[0]=0L;
        pib[1]=1L;
        int times=1;
        for(int i=2; i<=n; i++){
            pib[i]=(pib[i-1]+pib[i-2])%1234567L;
        }
        //answer=(int)(pib[n]%1234567L);
        answer=(int)(pib[n]);
        return answer;
    }
}