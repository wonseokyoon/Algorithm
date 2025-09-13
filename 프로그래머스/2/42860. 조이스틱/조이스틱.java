import java.util.*;
class Solution {
    public int solution(String name) {
        int upDown = 0;        
        for(char ch : name.toCharArray()){
            upDown += Math.min(ch - 'A','Z' - ch + 1);
        }
        System.out.println(upDown);
        
        char[] names = name.toCharArray();
        int leftRight = name.length() - 1;    // 기본값: 오른쪽으로 쭉 직진
        // 1. 왼쪽 찍고 오른쪽으로 다시 도착
        // 2. 오른쪽 찍고 왼쪽으로 다시 도착
        // 3. 왼쪽으로 쭉 직진 , 오른쪽으로 쭉 직진
        
        int len = name.length();
        for(int i = 0; i < len ; i++) {
            int next = i + 1;
            
            while(next < len && names[next] == 'A'){
                next ++;
            }
            
            // 1번 
            int temp1 = (len - next) * 2 + i;
            // 2번
            int temp2 = (i * 2) + len-next;
            leftRight = Math.min(leftRight,Math.min(temp1,temp2));
        }
        
        int answer = leftRight + upDown;
        return answer;
    }
}