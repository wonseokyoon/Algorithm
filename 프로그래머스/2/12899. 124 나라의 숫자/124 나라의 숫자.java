import java.util.*;
class Solution {
    public String solution(int n) {
        String[] digit ={"4","1","2"};
        String str = new String();
        while(n>0){
            int remain = n % 3;
            n/=3;
            
            if(remain == 0){
                n--;
            }
            str = digit[remain] + str;             
        }

        return str;
    }
}