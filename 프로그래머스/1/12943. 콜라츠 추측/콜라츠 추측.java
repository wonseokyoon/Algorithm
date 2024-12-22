class Solution {
    public int solution(int num) {
        long numl=num;
        int cnt=0;
        if(numl==1) return 0;
        while (numl > 1) {
            if (numl % 2 == 0) {
                numl /= 2;
            } else {
                numl = numl * 3 + 1;
            }
            cnt++;

            if (cnt > 500) return -1; // 500번 이상 반복 시 종료
        }
        return cnt;

    }
}