import java.util.*;
class Solution {
public int solution(int[] nums) {
        int n= nums.length/2;   //뽑아야하는 포켓몬 수
        
        HashSet<Integer> unique=new HashSet<>();
        for(int num:nums){
            unique.add(num);
        }
        if(unique.size()<n){
            return unique.size();
        }
        else{
            return n;
        }
    }
}