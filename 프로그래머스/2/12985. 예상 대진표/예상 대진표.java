class Solution {
    public int solution(int n, int a, int b) {
        if(a>b){
            int temp = a;
            a = b;
            b = temp;
        }

        int e = 0;  // 지수
        int temp =n;
        while (temp>1){
            temp/=2;
            e++;
        }

        int round = 0;
        while(a!=b){
            a = (a+1)/2;
            b = (b+1)/2;
            round++;
        }


        return round;
    }

}