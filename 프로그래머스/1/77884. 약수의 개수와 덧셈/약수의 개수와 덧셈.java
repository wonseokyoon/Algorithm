import java.util.ArrayList;
class Solution {
    public int solution(int left, int right) {
        ArrayList<Integer> sum=new ArrayList<>();
        for(int i=left;i<=right;i++){
            int cnt=0;
            for(int j=1;j<=Math.sqrt(i);j++){
                if(i%j==0){ //나눠지는 경우
                    cnt+=2;
                }
                if(j==Math.sqrt(i)) cnt--;
            }
            System.out.println(cnt);
            if(cnt%2==0){ //약수 개수 짝수
                sum.add(i);
            }
            else{   //약수 개수 홀수
                sum.add(-1*i);
            }
        }

        return sum.stream().mapToInt(Integer::intValue).sum();
    }
}