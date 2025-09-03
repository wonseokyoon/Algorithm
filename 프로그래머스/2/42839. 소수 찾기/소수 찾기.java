import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        char[] nums = numbers.toCharArray();
        boolean[] visited = new boolean[nums.length];
        // 완전 탐색으로 숫자를 만듬
        dfs("",nums,visited);

        int answer = 0;
        for(int num : set){
            if(isPrime(num)){
                answer ++;
            }
        }
        
        return answer;
    }
    
    public void dfs(String current, char[] nums, boolean[] visited){
        // set에 등록
        if(!current.equals("")){
            set.add(Integer.parseInt(current));
        }
        
        for(int i = 0; i<nums.length;i++){
            // 아직 사용 안 한 숫자
            if(!visited[i]){
                visited[i] = true;
                dfs(current+nums[i],nums,visited);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num){
        if(num < 2) return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
}