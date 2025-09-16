import java.util.*;
class Solution {
    public int solution(String name) {
        int upDown = 0;
        
        for(char ch : name.toCharArray()) {
            upDown += Math.min(ch - 'A', 'Z' - ch + 1);
        }
        System.out.println(upDown);
        
        char[] ch = name.toCharArray();
        int len = name.length();
        int leftRight = len - 1;
        for(int i = 0; i < len; i++) {
            int next = i+1;
            while(next < len && ch[next] == 'A'){
                next++;
            }
            // len = 9
            // next = 7
            // JAAAAAABB
            
            // 왼쪽 찍고, 오른쪽으로
            int left = i * 2 + len - next;
            // 오른쪽 돌아서 찍고, 다시 왼쪽으로
            int right = (len - next) * 2 + i;
            
            int min = Math.min(left,right);
            leftRight = Math.min(min,leftRight);
        }
        
        return upDown + leftRight;
    }
}