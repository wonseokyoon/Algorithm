class Solution {
public String solution(int n, int t, int m, int p) {
        StringBuilder str = new StringBuilder();
        StringBuilder res = new StringBuilder();
        int num = 0;
        int limit = t * m;
        while(str.length() < limit){
            // 10 진수 num 을 n 진법으로 변환
            String decimal = Integer.toString(num,n);
            str.append(decimal);
            num++;
        }

        int turn = 1;
        for(char c : str.toString().toCharArray()){
            turn = (turn % m == 0) ? turn : turn % m;
            if(turn == p){
                res.append(c);
                if(res.length() == t) break;
            }
            turn++;
        }
        return res.toString().toUpperCase();
    }
}