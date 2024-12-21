class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        // x를 배열에 저장
        String [] digits=String.valueOf(x).split("");
        int num=x;
        int sum=0;
        for(String digit:digits){
            sum+=Integer.parseInt(digit);   // 배열 순회하면서 합
        }
        if(x%sum==0) answer=true;
        return answer;
    }
}