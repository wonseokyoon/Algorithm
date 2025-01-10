class Solution {
    public int solution(String[] babbling) {
        String[] origin = {"aya", "ye", "woo", "ma"};
        int cnt = 0;

        for (String str : babbling) {
            String prev = "";  // 이전 발음
            boolean isValid = true;

            while (!str.isEmpty()) { // 공백이 아닌 문자가 남아있으면 계속 진행
                boolean found = false;

                for (String word : origin) {
                    if (str.startsWith(word)) { // 단어가 문자열의 시작과 일치하면
                        if (prev.equals(word)) {  // 이전 발음과 동일하면 무효
                            isValid = false;
                        } else {
                            prev = word; // 이전 발음 갱신
                        }
                        str = str.substring(word.length()); // 발음만큼 문자열을 줄임
                        found = true; // 발음이 발견됨
                        break; // 잘라내고 다음 반복으로
                    }
                }

                if (!found) { // 어떤 발음도 발견되지 않았다면 종료
                    isValid = false;
                    break;
                }
            }

            // 남은 문자열이 비어 있어야 유효한 발음으로 판단
            if (isValid && str.isEmpty()) {
                cnt++;
            }
        }
        return cnt;
    }
}