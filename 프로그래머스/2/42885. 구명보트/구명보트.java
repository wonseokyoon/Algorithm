import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(people);

        int light = 0; 
        int heavy = people.length -1;
        
        while(light <= heavy){
            if(people[light] + people[heavy] > limit){
                list.add(people[heavy]);
                heavy --;
            } else {
                list.add(people[heavy] + people[light]);
                heavy --;
                light ++;
            }
        }
        return list.size();
    }
}