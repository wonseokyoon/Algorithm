class Solution {
    public int[] solution(int n, int m) {
         if(Math.max(m,n)==n){
            int temp=m;
            m=n;
            n=temp;
        }
        int i=1;
        int gcd=i;
        if(m%n==0){
            return new int[]{n,m};
        }
        // 9 39-> gcd: 3, lcm: 9x39/gcd=117
        while(i<=n){    //최대공약수
            if(m%i==0 && n%i==0){
                gcd=i;
            }
            i++;
        }
        int lcm=(n*m)/gcd;
        return new int[]{gcd,lcm};
    }
}