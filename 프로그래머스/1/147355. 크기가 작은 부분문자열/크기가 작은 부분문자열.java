import java.util.ArrayList;

class Solution {
    public int solution(String t, String p) {
        Long num=Long.parseLong(p);    //p의 int형 변환
        int len=p.length(); //문자열 p의 길이
        ArrayList<String> str=new ArrayList<>();
        for(int i=0;i<=t.length()-len;i++){
            if(Long.parseLong(t.substring(i,i+len))<=num){
                str.add(t.substring(i,i+len));
            }
        }
        return str.size();
    }
}