import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
     public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char letter : s.toCharArray()) {
            int cnt = 0;
            while (cnt < index) {   // index번 반복
                letter = (letter == 'z') ? 'a' : (char) (letter + 1);
                if (!skip.contains(String.valueOf(letter))) {
                    cnt++;
                }
            }
            answer.append(letter);
        }
        return answer.toString();
    }
}