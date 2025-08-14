import java.util.Arrays;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int sum = 0;
        int end = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        int[] result = new int[2];
        for(end = 0; end < sequence.length; end++) {
            sum += sequence[end];

            while (sum > k){
                sum -= sequence[start];
                start ++;
            }

            if(sum == k){
                int len = end - start;
                if(len < min){
                    min = len;
                    result[0] = start;
                    result[1] = end;
                }
            }
        }

        return result;
    }
}