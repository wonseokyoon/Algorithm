import java.util.ArrayList;

class Solution {
   public int solution(int[] a, int[] b) {
        int size=a.length;
        ArrayList<Integer> answer=new ArrayList<Integer>();
        for(int i=0;i<size;i++){
            answer.add(a[i]*b[i]);
        }
        int sum=answer.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }
}