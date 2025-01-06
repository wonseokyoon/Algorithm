import java.util.*;
class Solution {
 public int solution(int number, int limit, int power) {
        int[] count=new int[number+1];
        for(int i=1;i<=number;i++){
            for(int j=1;j<=number/i;j++){
                count[i*j]++;
            }
        }
        int sum=0;
        for(int n:count){
            if(n>limit){
                sum+=power;
            }
            else{
                sum+=n;
            }
        }
        return sum;

    }
}