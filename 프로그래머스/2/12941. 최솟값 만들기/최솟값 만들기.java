import java.util.Arrays;
import java.util.Collections;
class Solution{
    
        public int solution(int []A, int []B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        int size = A.length;
        for(int i=0;i<size;i++){
            int product = A[i] * B[size-1-i];
            sum += product;
        }
        
        return sum;
    }
}