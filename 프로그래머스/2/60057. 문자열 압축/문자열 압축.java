import java.util.*;

class Solution {
    public int solution(String s) {
        int strLen = s.length();
        if(strLen == 1) return 1;
        int maxLen = strLen/2;
        
        int answer = Integer.MAX_VALUE;
        
        // 문자열을 len으로 압축했을때 문자열 길이를 구함
        for(int len = 1; len <= maxLen; len++){
            int zippedLen = zip(len,s);     // 압축 문자열 길이
            if(zippedLen < answer){
                answer = zippedLen;
            }
        }
        
        return answer;
    }
    
    // 문자열 s를 길이 len으로 압축한 길이
    int zip(int len, String s) {
        // 압축 문자열 저장 스트링빌더
        StringBuilder stringBuilder = new StringBuilder();
        
        // 문자열의 시작 지점        
        for(int i = 0; i< s.length();){
            // len 단위로 자름
            int endIdx = Math.min(i + len,s.length());
            String currentString = s.substring(i,endIdx);
            int cnt = 1;

            int next = i + len; // 다음 문자열
            while(next < s.length()){
                int nextEndIdx = Math.min(next + len , s.length());
                String nextString = s.substring(next,nextEndIdx);

                if(nextString.equals(currentString)){
                    cnt ++;
                    next+= len;  // 다음 위치 
                } else{
                    break;  // 종료
                }
            }

            // 겹치는 문자열이 있었던 경우
            if(cnt > 1){
                stringBuilder.append(cnt);
            }
            stringBuilder.append(currentString);
            i=next;
        }
        
        return stringBuilder.length();
    }
}