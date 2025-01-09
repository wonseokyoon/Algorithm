class Solution {
    public int solution(int n, int m, int[] section) {
        int roller=section[0];  //첫번째 지점 시작
        int cnt=1;

        for(int i=1;i< section.length;i++){
            if(roller+m-1<section[i]){  // 다음 영역을 못칠함
                cnt++;
                roller=section[i];  // 롤러의 시작점을 다음 지점으로 이동
            }
        }
        return cnt;
    }
}