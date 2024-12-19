class Solution {
    public int[] solution(long n) {
        int length=String.valueOf(n).length();
        int[] answer = new int[length];
        int i=0;
        while(n>=1){
            answer[i]=(int)(n%10);
            n/=10;
            i++;
        }
        return answer;
    }
}