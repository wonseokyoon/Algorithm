import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(6,1);
        map.put(5,2);
        map.put(4,3);
        map.put(3,4);
        map.put(2,5);
        map.put(1,6);
        map.put(0,6);
        int cnt=0;
        int zero=0;

        for(int lotto:lottos){
            if(lotto==0) zero++;
        }

        for(int win_num:win_nums){
            if(Arrays.stream(lottos).anyMatch(x->x==win_num)){
                cnt++;
            }
        }

        int[] answer={map.get(cnt+zero),map.get(cnt)};
        return answer;
    }
}