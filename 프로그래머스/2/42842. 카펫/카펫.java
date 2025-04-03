import java.util.Arrays;

class Solution {
        public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int sqrt = (int) Math.sqrt(sum);
        int width;
        int height = 0;
        for(int i = 3 ; i<= sqrt; i++){
            if(sum % i == 0){
                if((i-2) * ((sum / i) - 2) == yellow){
                    height = i;
                }
            }
        }
        width = sum / height;

        return new int[] {width,height};
    }
}