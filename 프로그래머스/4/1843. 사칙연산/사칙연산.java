import java.util.*;

class Solution {
    public int solution(String arr[]) {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<String> commends = new ArrayList<>();
        
        for(String str : arr){
            try {
                numbers.add(Integer.parseInt(str));
            } catch(Exception e){
                commends.add(str);
            }    
        }
        
        int cnt = numbers.size();
        
        int[][] max = new int[cnt][cnt];
        int[][] min = new int[cnt][cnt];
        
        for(int i = 0; i < cnt; i++){
            max[i][i] = numbers.get(i);
            min[i][i] = numbers.get(i);
        }
        
        for(int len = 2 ; len <= cnt ; len ++){
            
            for(int start = 0; start <= cnt - len; start++) {
                int end = start + len - 1;
                
                max[start][end] = Integer.MIN_VALUE;
                min[start][end] = Integer.MAX_VALUE;
                
                for(int i = start; i < end; i ++){
                    String commend = commends.get(i);
                    if(commend.equals("+")){
                        // 최댓값 + 최댓값
                        max[start][end] = Math.max(max[start][end], max[start][i] + max[i+1][end]);
                        // 최솟값 + 최솟값
                        min[start][end] = Math.min(min[start][end], min[start][i] + min[i+1][end]);
                        
                    } else{
                        // 최댓값 - 최솟값
                        max[start][end] = Math.max(max[start][end], max[start][i] - min[i+1][end]);
                        // 최솟값 - 최댓값
                        min[start][end] = Math.min(min[start][end], min[start][i] - max[i+1][end]);
                    }
                }
                
            }
        }
        
        
        return max[0][cnt-1];
    }
}