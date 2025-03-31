class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int temp = 0;
        int binaryCount = 0;
        while(!s.equals("1")){
            String removedString =  s.replaceAll("0","");
            temp = s.length() - removedString.length();
            cnt += temp;

            int length = removedString.length();
            s = Integer.toBinaryString(length);
            binaryCount ++;
        }
        int[] answer = {binaryCount, cnt};
        return answer;
    }
}