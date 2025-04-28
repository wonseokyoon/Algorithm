class Solution {
    public static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];   // 방문 여부
        dfs(k,dungeons,visited,0);
        return answer;
    }

    public void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        // 결론
        answer = Math.max(count,answer);

        for(int i = 0; i < dungeons.length; i++){
            // 방문한적 없고, k가 더 클때
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;  // 방문 처리
                dfs(k - dungeons[i][1],dungeons,visited,count+1);
                visited[i] = false; // 백트래킹
            }

        }

    }
}