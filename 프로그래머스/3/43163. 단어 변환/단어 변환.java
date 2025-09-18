import java.util.*;
class Solution {
    boolean[] visited;
    
    public class Status{
        private String current;
        private int cnt;
        
        public Status(String current, int cnt){
            this.current = current;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        int answer = bfs(begin,target,words,0);
        return answer;
    }
    
    int bfs(String current, String target, String[] words,int cnt){
        Queue<Status> queue = new LinkedList<>();
        queue.offer(new Status(current,cnt));
        
        while(!queue.isEmpty()) {
            Status status = queue.poll();
            String stockedStr = status.current;
            int stockedCnt = status.cnt;
            
            if(stockedStr.equals(target)) return stockedCnt;
            
            for(int i =0; i < words.length; i++) {
                String word = words[i];
                if(!visited[i] && canChange(word,stockedStr)) {    // 변환 가능
                    visited[i] = true;
                    queue.offer(new Status(word,stockedCnt+1));
                }
            }
        }
        return 0;
    }
    
    boolean canChange(String words, String targets) {
        char[] word = words.toCharArray();
        char[] target = targets.toCharArray();
        int cnt = 0;
        for(int i = 0; i < words.length(); i++){
            if(word[i] != target[i]) cnt ++;
            if(cnt > 1) return false;
        }
        
        return true;
    }
}