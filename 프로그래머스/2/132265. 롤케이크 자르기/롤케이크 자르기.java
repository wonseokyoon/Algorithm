import java.util.*;
class Solution {
    public int solution(int[] topping) {
        LinkedHashSet<Integer> left = new LinkedHashSet<>();
        int[] leftCount = new int[topping.length];
        LinkedHashSet<Integer> right = new LinkedHashSet<>();
        int[] rightCount = new int[topping.length];
        int answer = 0;
        for(int i = 0; i < topping.length; i++){
            left.add(topping[i]);
            leftCount[i] = left.size();
        }

        for(int i=topping.length-1; i>=1; i--){
            right.add(topping[i]);
            rightCount[i] = right.size();

            if(leftCount[i - 1] == rightCount[i]) answer++;
            if(leftCount[i - 1] < rightCount[i]) break;
        }

        return answer;
    }
}