import java.util.*;
class Solution {
        public int solution(int[] order) {
        Stack<Integer> assist = new Stack<>();  // 보조 벨트
        int cnt = 0;

        for(int i = 0; i < order.length; i++){
            assist.push(i+1);

            while(!assist.isEmpty()){
                if(assist.peek() == order[cnt]){
                    assist.pop();
                    cnt++;
                } else break;
            }
        }
        return cnt;
    }
}