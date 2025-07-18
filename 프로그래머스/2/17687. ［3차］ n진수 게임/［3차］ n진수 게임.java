class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder str = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int num = 0;
        int limit = t * m;

        // 10 진수 num 을 n 진법으로 변환
        while(str.length() < limit){
            String decimal = Integer.toString(num,n);
            str.append(decimal);
            num++;
        }

        int turn = 1;
        for(char c : str.toString().toCharArray()){
            // 나눠 떨어지지 않으면 나머지로 치환
            turn = (turn % m == 0) ? turn : turn % m;
            // 내차례
            if(turn == p){
                res.append(c);
                // 길이 충족시 종료
                if(res.length() == t) break;
            }
            turn++;
        }
        // 대문자 치환
        return res.toString().toUpperCase();
    }
}