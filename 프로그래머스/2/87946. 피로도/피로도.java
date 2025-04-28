class Solution {
    public int solution(int k, int[][] dungeons) {
        int[] answer = new int[1];
        boolean[] visited = new boolean[dungeons.length];   // 방문 여부
        explore(k,dungeons,visited,0,answer);
        return answer[0];
    }

    public void explore(int k, int[][] dungeons, boolean[] visited, int count, int[] answer) {
        // 결론
        answer[0] = Math.max(count,answer[0]);

        for(int i = 0; i < dungeons.length; i++){
            // 방문한적 없고, k가 더 클때
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;  // 방문 처리
                explore(k - dungeons[i][1],dungeons,visited,count+1,answer);
                visited[i] = false; // 백트래킹
            }

        }

    }
}