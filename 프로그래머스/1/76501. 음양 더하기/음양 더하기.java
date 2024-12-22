class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int len=absolutes.length;
        int [] digits=new int[len];
        for(int i=0;i<len;i++){
            if(signs[i]){   // 양수
                digits[i]=absolutes[i];
            }
            else{
                digits[i]=-1*absolutes[i];
            }
        }
        int sum=0;
        for (int digit:digits){
            sum+=digit;
        }
        return sum;
    }
}