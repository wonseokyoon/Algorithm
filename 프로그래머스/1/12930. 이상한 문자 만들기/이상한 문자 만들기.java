class Solution {
    public String solution(String s) {
        String answer="";
        int cnt=0;
        String[] str=s.split("");   // "t","r","y"," ", ...
        for(String word:str){
            cnt=word.contains(" ")?0:cnt+1; // 공백문자 나오면 0으로 초기화
            answer+=(cnt%2==0)?word.toLowerCase():word.toUpperCase();
        }
        return answer;

    }
}