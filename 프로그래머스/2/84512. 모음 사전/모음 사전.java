import java.util.*;
class Solution {
    String[] word = {"A","E","I","O","U"};
    ArrayList<String> dic = new ArrayList<>();

    public int solution(String words) {
        BruteForceSearch(words,"");

        int cnt = 0;
        for(String s : dic){
            System.out.println(s);
            if(s.equals(words)) return cnt;
            cnt++;
        }

        return cnt;
    }

    private void BruteForceSearch(String words, String cur) {
        if(cur.length() > 5){
            return;
        }

        dic.add(cur);
        for(int i = 0; i < 5; i++){
            BruteForceSearch(words,cur+word[i]);
        }
    }
}