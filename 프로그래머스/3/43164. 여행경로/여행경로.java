import java.util.*;
class Solution {
    boolean[] visited;
    List<String> answer;
    
    public String[] solution(String[][] tickets) {
        int airportCnt = tickets.length;
        visited = new boolean[airportCnt];  // 몇번 티켓을 사용했는지
        answer = new ArrayList<>();
        
        Arrays.sort(tickets,(s1,s2) -> s1[1].compareTo(s2[1]));

        dfs("ICN","ICN",tickets,airportCnt,0);
        
        return answer.toArray(new String[0]);
    }
    
    // 출발지, 경로, 티켓, 전체 티켓 수, 현재 사용한 티켓 수
    void dfs(String start, String path, String[][] tickets, int airportCnt, int cnt) {
        if(!answer.isEmpty()) return;
        if(cnt == airportCnt) {
            answer = Arrays.asList(path.split(" "));
            return;
        }
        
        for(int i = 0; i < airportCnt; i ++){
            String[] ticket = tickets[i];
            String from = ticket[0];
            String to = ticket[1];
            
            // 출발지 티켓을 찾음
            if(from.equals(start) && !visited[i]){
                visited[i] = true;  // 사용처리
                dfs(to,path + " "+to, tickets, airportCnt, cnt + 1);
                visited[i] = false;
            }
        }        
    }
}