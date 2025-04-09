import java.util.*;

class Solution {
 public int solution(int[] elements) {
        int size = elements.length;
        int max = Arrays.stream(elements).sum();
        int[] nums = new int[max+1];
        for(int i = 0; i < size; i++){
            int sum = 0;
            for(int j = 0; j < size; j++){
                sum += elements[(i+j)%size];
                nums[sum]++;
            }
        }

        int ans = 0;
        for(int i = 1; i <= max; i++){
            if(nums[i] >= 1){
                ans++;
            }
        }

        return ans;
    }

}