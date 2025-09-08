import java.util.*;

class Solution {
    public char[] words = { 'A', 'E', 'I', 'O', 'U'};
    ArrayList<String> list = new ArrayList<>();
    public int solution(String word) {
        
        dfs(new StringBuilder(), 0,word);
        
        int answer = list.indexOf(word) + 1;
        return answer;
    }
    
    public void dfs(StringBuilder sb , int length, String target){
        if(length > 0) {
            if(length == 5) {
                list.add(sb.toString());
                return;
            }
            list.add(sb.toString());
        }
        
        for(char word : words) {
            dfs(sb.append(word),length + 1,target);
            sb.setLength(length);
        }
        
    }
}