import java.util.*;
class Solution {
    public String solution(int n) {
        String[] digit ={"4","1","2"};
        StringBuilder sb = new StringBuilder();
        while(n>0){
            int remain = n % 3;
            n/=3;
            
            if(remain == 0){
                n--;
            }
            
            sb.append(digit[remain]);
        }
        sb.reverse();

        return sb.toString();
    }
}