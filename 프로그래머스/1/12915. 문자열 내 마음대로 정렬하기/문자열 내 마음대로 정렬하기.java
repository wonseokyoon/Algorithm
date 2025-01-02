import java.util.*;
class Solution {
     public String[] solution(String[] strings, int n) {
        ArrayList<String> str=new ArrayList();
        for(int i=0;i< strings.length;i++){
            str.add(strings[i].charAt(n)+strings[i]);
        }   // babce babcd dcdx
        Collections.sort(str);
        String[] answer=new String[strings.length];
        for(int i=0;i< strings.length;i++){
            answer[i]=str.get(i).substring(1);
        }

        return answer;

    }
}