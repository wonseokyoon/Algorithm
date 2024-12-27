import java.util.*;

public class Solution {
    public int[] solution(int[] arr1) {
        ArrayList<Integer> answer=new ArrayList<>();
        int previous=-1;
        for(int num:arr1){
            if(num!=previous) answer.add(num);
            previous=num;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}