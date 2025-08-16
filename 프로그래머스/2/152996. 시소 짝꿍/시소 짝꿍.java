import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        // 무게 별 몇명이 있는지 카운트
        Map<Double, Integer> map = new HashMap<>();
        for (int weight : weights) {
            map.put((double) weight, map.getOrDefault((double) weight, 0) + 1);
        }

        // 정렬
        Arrays.sort(weights);

        for (int weight : weights) {
            double doubleWeight = (double) weight;
            long cnt = map.get(doubleWeight);

            if (cnt == 0) continue;

            // 같은 무게끼리 짝꿍
            // n명중 2명의 조합: nC2 -> n*(n-1)/2
            if (cnt > 1) {
                answer += cnt * (cnt - 1) / 2;
            }

            // 2:3
            double partner = (doubleWeight * 3) / 2;
            if (map.containsKey(partner)) {
                answer += cnt * map.get(partner);
            }

            // 2:4
            double partner2 = (doubleWeight * 2);
            if (map.containsKey(partner2)) {
                answer += cnt * map.get(partner2);
            }

            // 3:4
            double partner3 = (doubleWeight * 4) / 3;
            if (map.containsKey(partner3)) {
                answer += cnt * map.get(partner3);
            }

            map.put(doubleWeight, 0);
        }

        return answer;
    }
}