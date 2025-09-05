import java.util.*;
class Solution {
    public char[] words = {'A', 'E', 'I', 'O', 'U'};
    public ArrayList<String> dictionary = new ArrayList<>();
    
    public int solution(String word) {
        
        dfs(new StringBuilder(),0);
        int answer = dictionary.indexOf(word);
        
        return answer;
    }
    
    void dfs(StringBuilder current,int len) {
        if(len > 5) return;
        
        dictionary.add(current.toString());
        
        for(char word : words) {
            dfs(current.append(word), len+1);
            current.setLength(len);
        }
    }
}