import java.util.*;
class Solution {
    public boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length]; 
        int answer = bfs(words,begin,target,0);
        return answer;
    }
    
    int bfs(String[] words,String begin,String target,int cnt) {
        Queue<String[]> queue = new LinkedList<>();

        queue.offer(new String[]{begin,target,String.valueOf(cnt)});
 
        while(!queue.isEmpty()){
            String[] current = queue.poll();
            String currentWord = current[0];
            String targetWord = current[1];
            int currentCnt = Integer.parseInt(current[2]);
            
            if(currentWord.equals(targetWord)) {
                return currentCnt;
            }
            
            // 변환 가능한 단어 탐색
            for(int i = 0; i< words.length; i ++){
                if(visited[i]) continue;
                
                // 변환 가능하다면(단어 하나만 변경)
                if(canChange(currentWord,words[i])){
                    visited[i] = true;      // 방문 처리
                    queue.offer(new String[]{words[i],target,String.valueOf(currentCnt + 1)});
                } 
            }
        }
        return 0;
    }
    
    boolean canChange(String current, String target){
        int diff = 0;
        char[] ch1 = current.toCharArray();
        char[] ch2 = target.toCharArray();
        for(int i = 0; i< current.length();i++){
            if(ch1[i] != ch2[i]) diff++;
            if(diff > 1) {
                return false;
            }
        }
        return true;
    }
}