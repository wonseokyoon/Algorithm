import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public long solution(long n) {
        String str=Long.toString(n);
        ArrayList<Character> digit=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            digit.add(str.charAt(i));
        }
        //내림차순 정렬
        Collections.sort(digit,Collections.reverseOrder()); 
        StringBuffer sb=new StringBuffer();
        for(char d:digit){
            sb.append(d);
        }
        //long 타입으로 형변환
        return Long.parseLong(sb.toString());   
    }
}