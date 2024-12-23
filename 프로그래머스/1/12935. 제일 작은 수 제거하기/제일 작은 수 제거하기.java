import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        int min=Arrays.stream(arr).min()
            .orElse(-1);
        ArrayList<Integer> answer=new ArrayList<>();
        for(int digit:arr){
            if(min!=digit){
                answer.add(digit);
            }
        }
        int [] empty={-1};
        if(answer.isEmpty()){
            return empty;
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}