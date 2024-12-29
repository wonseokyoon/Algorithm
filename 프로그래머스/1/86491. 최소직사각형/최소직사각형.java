
class Solution {
    public int solution(int[][] sizes) {
        int len=0;
        int hei=0;
        for(int[] size: sizes){
            len=Math.max(len,Math.max(size[0],size[1]));
            hei=Math.max(hei,Math.min(size[0],size[1]));
        }
        int answer = len*hei;
        return answer;
    }
}