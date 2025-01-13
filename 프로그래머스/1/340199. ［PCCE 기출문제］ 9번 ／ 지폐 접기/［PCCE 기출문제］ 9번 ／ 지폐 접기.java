import java.util.*;
class Solution {
    public int solution(int[] wallet, int[] bill) {

        Arrays.sort(bill);
        Arrays.sort(wallet);
        int bmin = bill[0]; // 17
        int bmax = bill[1]; // 26
        int wmin = wallet[0];   // 15
        int wmax = wallet[1];   // 30
        int cnt = 0;

        while(true){
            if(bmin<=wmin && bmax<=wmax) break;

            if(bmin==bill[0]){
                bill[1]/=2;
            }else {
                bill[0]/=2;
            }
            bmin=Math.min(bill[0],bill[1]); //최소값 갱신
            bmax=Math.max(bill[0],bill[1]); //최소값 갱신

            cnt++;
        }
        return cnt;
    }
}