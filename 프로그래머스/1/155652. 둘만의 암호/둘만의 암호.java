import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
     public String solution(String s, String skip, int index) {
        String alpabet="abcdefghijklmnopqrstuvwxyz";
        List<String> list= new ArrayList<>(Arrays.asList(alpabet.split("")));
        System.out.println(list);
        String[] skiplist=skip.split("");
        for(String c:skiplist){ // skip 제거
            if(list.contains(c)){
                list.remove(c);
            }
        }
        int size= list.size();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            int afterindex=list.indexOf(String.valueOf(s.charAt(i)));
            afterindex=(afterindex+index)%size;
            sb.append(list.get(afterindex));
        }

        return sb.toString();

    }
}