import java.util.*;
class Solution {
     public int solution(int[] wallet, int[] bill) {
        int cnt = 0;
        while(true){
            if(min(bill)<=min(wallet) && max(bill)<=max(wallet)) break;
            bill[bill[0]>bill[1]? 0:1]/=2;
            cnt++;
        }
        return cnt;
    }

    public int max(int[] arr){
        return Math.max(arr[0],arr[1]);
    }
    public int min(int[] arr){
        return Math.min(arr[0],arr[1]);
    }
}