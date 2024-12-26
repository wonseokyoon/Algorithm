import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
     public String solution(String s) {
        List<String> str=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            str.add(String.valueOf(s.charAt(i)));
        }
        Collections.sort(str,Collections.reverseOrder());   //내림차순
        String answer=String.join("",str);
        return answer;
    }
}