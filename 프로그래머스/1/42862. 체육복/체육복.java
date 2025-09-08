import java.util.*;

class Solution {
    public int solution(int n, int[] losts, int[] reserves) {
        int[] arr = new int[n];
        Arrays.fill(arr,1);
        
        for(int lost : losts){
            arr[lost - 1] --;
        }
        
        for(int reserve : reserves){
            arr[reserve - 1] ++;
        }
        
        int cnt = n;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0){
                // 왼쪽에서 빌림
                if(i > 0 && arr[i-1] == 2) {
                    arr[i-1]--;
                } else if (i < n-1 && arr[i+1] == 2) {  // 오른쪽에서 빌림
                    arr[i+1]--;
                } else{
                    cnt --;
                }
            }
        }
        
        
        return cnt;
    }
}