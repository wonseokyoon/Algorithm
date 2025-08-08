import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Long> q1 = Arrays.stream(queue1)
                .mapToLong(i -> i)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        Queue<Long> q2 = Arrays.stream(queue2)
                .mapToLong(i -> i)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        long sum1 = q1.stream().mapToLong(Long::longValue).sum();
        long sum2 = q2.stream().mapToLong(Long::longValue).sum();
        long target = (sum1 + sum2) / 2;
        int max_count = (queue1.length + queue2.length) * 2; 
        while (sum1 != target) {
            if(answer > max_count) return -1;

            if (sum1 > target) {
                // queue1 -> queue2 원소 이동

                long number = q1.poll();
                q2.add(number);
                sum1 -= number;
                answer++;
            } else {
                long number = q2.poll();
                q1.add(number);
                sum1 += number;
                answer++;
            }
        }

        if(answer == 2 * queue1.length) return -1;
        return answer;
    }
}