import java.util.Arrays;
class Solution {
    public long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            if (number % 2 == 0) {       // 마지막 비트가 0 -> 그냥 +1
                result[i] = numbers[i] + 1;
                continue;
            }

            // XOR
            long xor = number ^ (number+1);
            // 2칸 시프트
            long shiftXor = xor>>2;
            // OR 연산
            result[i] = number+1 | shiftXor;
        }

        return result;
    }
}