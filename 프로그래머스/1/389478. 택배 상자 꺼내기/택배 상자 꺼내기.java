class Solution {
public int solution(int n, int w, int num) {
        // 몇번째 층에 위치하는지(row)
        int row=(num-1) / w;

        // 몇번째 열에 위치하는지(col)
        int col=(num-1) % w;

        // 방향에 따른 열 찾기
        if(row%2==0){   // ->

        }else{  // <-
            col= w - 1 - col;
        }

        // 상자 수 계산
        int cnt=0;
        for(int i=row;i<=(n-1)/w;i++){
            if(i%2==0){ //  ->
                if(i * w + (col+1) <= n ) cnt++;
            }else{  // <-
                if(i * w + (w-col) <= n ) cnt++;
            }
        }

        return cnt;
    }
}