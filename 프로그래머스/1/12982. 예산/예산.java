import java.util.Arrays;
class Solution {
    public int solution(int[] d, long budget) {
        Arrays.sort(d); //정렬하여 최대한 많은 금액 지원
        long remain = budget;  //남은 돈
        int cnt=0;
        for (int i = 0; i < d.length; i++) {
            int amount = d[i];
            remain-=amount;
            if(remain==0){
                return i+1;
            } else if (remain<0) {
                return i;
            }
        }
        return d.length;
    }
}