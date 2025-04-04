import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        Map<Integer,Integer> map = new HashMap<>();

        for(int n:tangerine){
            map.put(n,map.getOrDefault(n,0) + 1);
        }

        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Comparator.reverseOrder());

        int sum = 0;
        int cnt = 0;

        for(int count:counts){
            sum += count;
            cnt++;
            if(k<=sum){
                break;
            }
        }

        return cnt;
    }
}