class Solution {
    public int solution(int[] number) {
        int cnt=0;
        for(int i=0;i<=number.length-3;i++){
            for(int j=i+1;j<= number.length-2;j++){
                for(int k=j+1;k<=number.length-1;k++){
                    if(number[i]+number[j]+number[k]==0){
                        cnt++;
                    }
                }
            }

        }
        return cnt;
    }
}