import java.util.*;
class Solution {
    public int[] solution(String msg) {
        // 사전 등록
        String[] words = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        ArrayList<String> dictionary = new ArrayList<>(Arrays.asList(words));
        ArrayList<Integer> result = new ArrayList<>();
        int idx = 0;
        int len = 1;    // 부분 문자열 길이
        while(idx + len <= msg.length()) {
            String curWord = msg.substring(idx, idx+len);
            // 사전에 있으면
            if(dictionary.contains(curWord)) {
                // 뒤 문자와 압축
                len++;
                continue;
            }

            // 사전에 없으면: 현재 문자 사전에 등록
            dictionary.add(curWord);

            // 직전 문자 결과 출력
            result.add(dictionary.indexOf(curWord.substring(0, curWord.length()-1)));
            idx += len - 1; // idx 갱신
            len = 1;    // 초기화
        }

        // 마지막 문자열 출력
        result.add(dictionary.indexOf(msg.substring(idx,(idx+len-1))));


        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}