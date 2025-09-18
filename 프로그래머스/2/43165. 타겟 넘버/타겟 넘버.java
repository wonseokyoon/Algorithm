class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        boolean[] visited = new boolean[numbers.length];
        int current = 0;
        int len = numbers.length;
        
        dfs(0,current,target,len,numbers);
        
        return answer;
    }
    
    void dfs(int idx, int current, int target, int len,int[] numbers){
        if(idx == len) {
            if(current == target) answer ++;
            return;
        }
        
        // 더하기 
        dfs(idx+1,current + numbers[idx],target,len,numbers);
        // 빼기
        dfs(idx+1,current - numbers[idx],target,len,numbers);
    }
}