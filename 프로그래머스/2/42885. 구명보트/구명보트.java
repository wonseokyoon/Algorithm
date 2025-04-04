import java.util.ArrayList;
import java.util.Arrays;
class Solution {
     public int solution(int[] peoples, int limit) {
        Arrays.sort(peoples);
        ArrayList<Integer> list = new ArrayList<>();
        int light = 0;
        int heavy = peoples.length-1;

        while(light <= heavy) {

            if(peoples[light] + peoples[heavy] > limit){
                list.add(peoples[heavy]);
                heavy--;
            }else {
                list.add(peoples[heavy] + peoples[light]);
                light++;
                heavy--;
            }

        }

        System.out.println(list);

        return list.size();
    }
}