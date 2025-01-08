import java.util.*;
class Solution {
    public int solution(int[] nums) {
        // 조합해주는 함수
        List<Integer> current = new ArrayList<>();
        // 소수 판별 함수
        int[] cnt={0};
        Combination(0, nums,current,cnt);
        return cnt[0];
    }
    public void Combination(int start,int[] nums
    ,List<Integer> current,int[] cnt){
        if(current.size()==3){
            if(isPrime(current)){
                cnt[0]++;
            }
            return;
        }

        for(int i=start;i< nums.length;i++){
            current.add(nums[i]);
            Combination(i+1, nums, current,cnt);
            current.remove(current.size()-1);   //백트래킹
        }

    }

    private boolean isPrime(List<Integer> current) {
        int n=current.stream().mapToInt(Integer::intValue).sum();
        //7
        if(n<2) return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0) return false;
        }
        return true;

    }

}