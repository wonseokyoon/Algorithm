class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cntp=0;
        int cnty=0;
        s=s.toLowerCase(); // 소문자 변환
        // toUpperCase(): 대문자 변환
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='p' ){
                cntp++;
            }
            else if(s.charAt(i)=='y'){
                cnty++;
            }
        }
        if(cntp!=cnty) answer=false;         

        return answer;
    }
}