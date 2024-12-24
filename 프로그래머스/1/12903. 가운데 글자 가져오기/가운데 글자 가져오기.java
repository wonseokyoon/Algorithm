class Solution {
    public String solution(String s) {
        int size=s.length();
       String answer;
       if(size%2==1){   //홀수
           answer=String.valueOf(s.charAt(size/2));
       }
       else{    //짝수 2,4: 2 3
           answer=String.valueOf(s.substring(size/2-1,size/2+1));
       }
       return answer;
    }
}