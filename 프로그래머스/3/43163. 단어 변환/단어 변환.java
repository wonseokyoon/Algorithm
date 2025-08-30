import java.util.*;
class Solution {
    public boolean[] visited;
    
    static class State {
        private final String word;
        private final int cnt;
        
        public State(String word,int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length]; 
        int answer = bfs(words,begin,target);
        return answer;
    }
    
    int bfs(String[] words,String begin,String target) {
        Queue<State> queue = new LinkedList<>();

        queue.offer(new State(begin,0));
 
        while(!queue.isEmpty()){
            State current = queue.poll();
            String currentWord = current.word;
            int currentCnt = current.cnt;
            
            if(currentWord.equals(target)) {
                return currentCnt;
            }
            
            // 변환 가능한 단어 탐색
            for(int i = 0; i< words.length; i ++){
                // 변환 가능하다면(단어 하나만 변경)
                if(!visited[i] && canChange(currentWord,words[i])){
                    visited[i] = true;      // 방문 처리
                    queue.offer(new State(words[i],currentCnt + 1));
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