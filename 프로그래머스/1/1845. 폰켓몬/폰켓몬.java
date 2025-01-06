import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int n= nums.length/2;   //뽑아야하는 포켓몬 수

        int[] unique=Arrays.stream(nums).distinct().toArray();

        if(unique.length<n){
            return unique.length;
        }
        else{
            return n;
        }
    }
}