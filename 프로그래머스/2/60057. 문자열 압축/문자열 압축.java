import java.util.*;

class Solution {
    public int solution(String s) {
        int strLen = s.length();            // 문자열 길이
        int compressedMaxLen = strLen/2;    // 최대 압축 길이
        
        if(strLen == 1) return 1;            // 문자열 길이가 1이면 바로 반환
        
        int minLen = Integer.MAX_VALUE;     // 최솟값
        // 1부터 시작해서 최대 압축 길이까지 전부 압축 해보고 최솟값을 구함
        for(int compressedLen = 1; compressedLen<= compressedMaxLen; compressedLen++) {
            int len = compress(compressedLen, s);     // 압축 후 최솟값
            if(len < minLen) minLen = len;
        }
        return minLen;
    }
    
    int compress(int compressedLen, String s) {
        StringBuilder stringBuilder = new StringBuilder();  // 문자열을 저장
        // 0부터 시작
        for(int i = 0 ; i < s.length();){
            int endIdx = Math.min(s.length(), i + compressedLen);   // 범위 초과 방지
            String current = s.substring(i,endIdx);

            int nextIdx = endIdx;
            int cnt = 1;
            while(nextIdx < s.length()) {
                int nextEndIdx = Math.min(s.length(), nextIdx + compressedLen);   // 범위 초과 방지
                String next = s.substring(nextIdx,nextEndIdx);
            
                if(next.equals(current)){
                    cnt++;
                    nextIdx += compressedLen;
                }
                else break;
            }
            
            if(cnt > 1) stringBuilder.append(cnt);
            stringBuilder.append(current);
            
            i = nextIdx;    // i값을 재설정
        }
        return stringBuilder.length();
    }
}