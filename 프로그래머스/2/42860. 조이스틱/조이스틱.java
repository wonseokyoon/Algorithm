class Solution {
    public int solution(String name) {
        char[] names = name.toCharArray();
        int updown = 0;
        
        // 알파벳 변경 횟수
        for(char ch : names) {
            updown += Math.min(ch - 'A', 'Z' - ch + 1);
        }
        
        int len = name.length();
        int leftRight = len - 1;
        for(int i = 0; i < len; i++) {
            int next = i + 1;
            
            // A가 몇개나 있는지 확인
            while(next < len && names[next] == 'A') {
                next++;
            }
            
            // 1. 오른쪽 찍고 왼쪽으로 방향 전환
            leftRight = Math.min(i * 2 + (len - next), leftRight);
            
            // 2. 왼쪽 찍고 오른쪽으로 방향 전환
            leftRight = Math.min((len - next) * 2 + i, leftRight);
        }
        
        return leftRight + updown;
    }
}