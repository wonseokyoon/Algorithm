import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int solution(int n) {
        int div=1; //몫
        int mod=1; // 나머지
        ArrayList<Integer> num3=new ArrayList<>();
        while(div>0){
            div=n/3;
            mod=n%3;
            n/=3;
            num3.add(mod);
        }
        int ans=0;
        int cnt=0;
        Collections.reverse(num3);
        //System.out.println(Arrays.toString(num3.stream().mapToInt(Integer::intValue).toArray()));
        for(int num:num3){
            ans+=num*Math.pow(3,cnt);
            cnt++;
        }
        return ans;

    }
}