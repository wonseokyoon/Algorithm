import java.util.*;

class Solution {
    public int solution(String arr[]) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<String> commends = new ArrayList<>();
        
        for(String str : arr){ 
            try {
                nums.add(Integer.parseInt(str));
            } catch(Exception e) {
                commends.add(str);
            }
        }
        
        int cnt = nums.size();
        
        int[][] maxDp = new int[cnt][cnt];
        int[][] minDp = new int[cnt][cnt];
        
        for(int i = 0; i < cnt; i ++) {
            maxDp[i][i] = nums.get(i);
            minDp[i][i] = nums.get(i);
        }
        
        for(int length = 2; length <= cnt; length ++) {     // 연산 길이
            for(int start = 0; start <= cnt - length; start ++) {   // 시작
                int end = start + length - 1;       // 끝
                
                maxDp[start][end] = Integer.MIN_VALUE;
                minDp[start][end] = Integer.MAX_VALUE;
                
                for(int i = start; i < end; i ++) {      // 연산자 위치(분할 위치)
                    String commend = commends.get(i);
                    
                    if(commend.equals("+")) {
                        // 최댓값 + 최댓값
                        maxDp[start][end] = Math.max(maxDp[start][end], maxDp[start][i] + maxDp[i+1][end]);
                        // 최솟값 + 최솟값
                        minDp[start][end] = Math.min(minDp[start][end], minDp[start][i] + minDp[i+1][end]);
                    } else{
                        // 최댓값 - 최솟값
                        maxDp[start][end] = Math.max(maxDp[start][end], maxDp[start][i] - minDp[i+1][end]);
                        // 최솟값 - 최댓값
                        minDp[start][end] = Math.min(minDp[start][end], minDp[start][i] - maxDp[i+1][end]);
                    }
                }
            }
        }
        
        int answer = maxDp[0][cnt-1];
        return answer;
    }
}