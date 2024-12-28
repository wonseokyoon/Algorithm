import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
class Solution {
    public int solution(int n) {
        String str="";
        while(n>0){
            str=(n%3)+str; //1 1 2 0
            n/=3;
        }
        // List<String> answer=new ArrayList<>(Arrays.asList(str.split("")));
        // Collections.reverse(answer);
        // return Integer.parseInt(String.join("",answer),3);
        
        StringBuilder sb=new StringBuilder();
        str=sb.append(str).reverse().toString();
        return Integer.parseInt(str,3);
    }
}