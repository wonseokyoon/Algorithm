import java.util.*;

class Solution {
public int[] solution(int n, String[] words) {
        int row = 1;
        int col = 1;
        Map<String,Integer> map = new HashMap<>();
        String prev = "0";
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
            // 끝말잇기가 실패했거나 단어가 두번 나온 경우
            if(map.get(word)==2 || !checkWord(prev,word)){
                return new int[]{col,row};
            }
            if(col == n){
                row ++;
                col-= n-1;
                prev = word;
                continue;
            }
            col ++;
            prev = word;
        }
        return new int[]{0,0};
    }

    // 성공하면 true 반환
    public boolean checkWord(String prev,String word) {
        char end = prev.charAt(prev.length()-1);
        char start = word.charAt(0);
        if(end==start || end=='0'){
            return true;
        }else{
            return false;
        }

    }
}