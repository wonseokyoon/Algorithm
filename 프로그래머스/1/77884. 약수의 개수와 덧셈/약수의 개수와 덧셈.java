import java.util.ArrayList;
class Solution {
    public int solution(int left, int right) {
         ArrayList<Integer> sum=new ArrayList<>();
        for(int i=left;i<=right;i++) {
            if(i%Math.sqrt(i)==0){  //제곱수: 약수 개수 홀수개
                sum.add(-i);
            }
            else{
                sum.add(i);
            }
        }
        return sum.stream().mapToInt(Integer::intValue).sum();
    
    }
}