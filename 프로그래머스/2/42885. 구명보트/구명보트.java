import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int light = 0; 
        int heavy = people.length - 1;
        int cnt = 0; 
        while(light <= heavy){
            
            // 둘이 탈 수 있음
            if(people[heavy] + people[light] <= limit){
                cnt ++; 
                heavy --; 
                light ++;
            } else {    // 혼자만 탐
                cnt ++;
                heavy --;
            }
        }
        return cnt;
    }
}