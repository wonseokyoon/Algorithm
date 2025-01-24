import java.util.*;
class Solution {
     public int solution(int[] ingredient) {
        int[] target={1,2,3,1};
        //2, 1, 1, 2, 3, 1, 2, 3, 1}
        Stack<Integer> stack=new Stack<>();
        int cnt=0;
        int index=0;
        for(int num:ingredient){
            stack.push(num);
            index++;
            if(stack.size()>= 4){
                if(stack.get(index-1)==1
                && stack.get(index-2)==3 && stack.get(index-3)==2
                && stack.get(index-4)==1){
                    index-=4;
                    for(int i=0;i<4;i++) stack.pop();
                    cnt++;
                }
            }
        }
        return cnt;
    }

}