import java.util.List;
import java.util.ArrayList;

class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        String strx=Integer.toString(x);    // x의 문자열 변환
        int cnt=strx.length();      // 몇자리 숫자인지 확인
        List<Integer> digits=new ArrayList<>();
        int num=x;
        for(int i=0;i<cnt;i++){
            digits.add(num%10);   //4,3,2,1
            num/=10;
        }
        int sum=0;
        for(int digit:digits){  // 각 자리의 합계
            sum+=digit;
        }
        if(x%sum==0){   //하샤드(나누어지는지) 확인
            answer=true;
        }
        return answer;
    }
}