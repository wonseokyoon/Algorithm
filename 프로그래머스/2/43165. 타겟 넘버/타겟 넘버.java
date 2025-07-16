class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers,target,0,0);
    }

    private int dfs(int[] numbers, int target, int index, int sum) {
        int cnt = 0;
        // 종료 조건 체크        
        if(index == numbers.length){
            // 조건에 맞으면 1 반환 아니면 0 반환
            if(sum == target){
                return 1;
            }
            return 0;
        }
        
        // + 부호 추가, 조건에 해당되면 +1, 아니면 아무일도 안일어남
        cnt += dfs(numbers,target,index+1,sum+numbers[index]);
        // - 부호 추가, 조건에 해당되면 +1, 아니면 아무일도 안일어남
        cnt += dfs(numbers,target,index+1,sum-numbers[index]);
        
        // 최종 갯수 반환
        return cnt;
    }
}