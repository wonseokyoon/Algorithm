import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> sum=new ArrayList<>();
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j< numbers.length;j++){
                sum.add(numbers[i]+numbers[j]);
            }
        }
        return sum.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
    }
}