import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        Map<Integer,Integer> map = new HashMap<>();

        for(int n:tangerine){
            map.put(n,map.getOrDefault(n,0) + 1);
        }
        List<Map.Entry<Integer,Integer>> sortedMap = new ArrayList<>(map.entrySet());
        sortedMap.sort(Map.Entry.comparingByValue());

        Stack<Integer> stack = new Stack<>();
        for(Map.Entry<Integer,Integer> entry:sortedMap){
            stack.push(entry.getValue());
        }

        int sum = 0;
        int cnt = 0;
        int n;
        while(true){
            if(stack.isEmpty() || sum == k ){
                break;
            }

            n = stack.peek();
            sum += n;
            cnt ++;
            if(sum >= k){
                break;
            }
            stack.pop();
        }

        return cnt;
    }
}