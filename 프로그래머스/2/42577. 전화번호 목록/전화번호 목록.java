import java.util.*;
class Solution {
    public boolean solution(String[] s) {
        Arrays.sort(s); // 사전순 정렬
        for(int i = 0; i<s.length-1; i++){
            if(s[i+1].startsWith(s[i])) return false;
        }
        return true;
    }
}