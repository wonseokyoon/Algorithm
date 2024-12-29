import java.util.HashMap;
class Solution {
    public int[] solution(String s) {
        HashMap<Character,Integer> map=new HashMap<Character, Integer>();
        char[] str=s.toCharArray();   // f,o,o,t,b,a,r
        int[] answer=new int[s.length()];
        for(int i=0;i<s.length();i++){
            answer[i]=i-map.getOrDefault(str[i],i+1);
            map.put(str[i],i);
        }
        return answer;
    }
}