class Solution {
    public int[] solution(int n, int m) {
        int gcd=Gcd(n,m);
        int lcm=n*m/gcd;
        return new int[]{gcd,lcm};
    }
    public static int Gcd(int n,int m){
        if(n%m==0){
            return m;
        }
        else{
            return Gcd(m,n%m);
        }
    }
}