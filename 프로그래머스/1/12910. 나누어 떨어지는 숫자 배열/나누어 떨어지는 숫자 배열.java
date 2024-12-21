import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int [] digits=Arrays.stream(arr)    //스트림 호출
                .filter(factor -> factor %divisor==0)   //조건식, 0이면 저장
                .toArray(); //리스트 변환
        if(digits.length==0){   // 빈 리스트
            return new int[] {-1};
        }
        Arrays.sort(digits);
        return digits;
    }
}