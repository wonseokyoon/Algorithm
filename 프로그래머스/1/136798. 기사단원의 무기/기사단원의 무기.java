import java.util.*;
class Solution {
public int solution(int number, int limit, int power) {
        ArrayList<Integer> answer=new ArrayList<>();
        for(int i=1;i<=number;i++){
            int cnt=0;
            int num= (int) Math.sqrt(i);    //2
            while(num>=1){
                if(i%num==0){   // 나머지 0
                    cnt++;
                    if(i/num !=num){    //제곱근이면 카운트-1
                        cnt++;
                    }
                }
                num--;
            }
            answer.add((cnt>limit)?power:cnt);
        }
        return answer.stream().mapToInt(Integer::intValue).sum();
    }
}