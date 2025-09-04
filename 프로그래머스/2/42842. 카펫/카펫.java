import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        
        for(int height = 3; height <= Math.sqrt(sum); height++){
            if(sum % height == 0){
                int width = sum / height;
                if((width - 2) * (height - 2) == yellow){
                    return new int[]{width,height};
                }
            }
        }
        int[] answer = {};
        return answer;
    }
}