class Solution {
    public int solution(String[] babbling) {
        String[] origin = {"aya", "ye", "woo", "ma"};
        int cnt = 0;

        for (String str : babbling) {
            String prev = ""; // 이전 발음
            boolean isValid = true;

            // 문자열이 공백이 아닐때까지 수행
            while (!str.isEmpty()) {
                boolean found = false;

                for (String word : origin) {
                    if (str.startsWith(word)) { // 단어가 문자열의 시작과 일치하는 경우
                        if (prev.equals(word)) { // 이전 발음과 동일하면 무효
                            isValid = false;
                        } else {
                            prev = word; // 이전 발음 갱신
                        }
                        str = str.replaceFirst(word, ""); // 발음 제거
                        found = true; // 발음이 발견됨
                        break; // 일치하는 첫 번째 발음만 처리한 후 종료
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