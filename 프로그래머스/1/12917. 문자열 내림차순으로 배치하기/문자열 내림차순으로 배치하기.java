import java.util.Arrays;
class Solution {
     public String solution(String s) {
        char[] c= s.toCharArray();  // 문자열 s를 char 배열로 변환
        Arrays.sort(c); // 오름차순 정렬
        StringBuilder sb=new StringBuilder(new String(c));
        sb.reverse();
        return sb.toString();
    }
}