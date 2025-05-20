import java.util.ArrayList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        ArrayList<String> cache = new ArrayList<>();
        int runTime = 0;

        // 무조건 미스
        if(cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            city = city.toLowerCase();

            // 캐시가 가득차지 않은 경우
            if (cache.size() != cacheSize) {
                // 히트
                if(cache.contains(city)) {
                    runTime++;
                    cache.remove(city);
                    cache.add(city);
                }
                // 미스
                else{
                    cache.add(city);
                    runTime += 5;
                }
            }else{  // 캐시가 가득 찬 경우
                // 히트
                if (cache.contains(city)) {
                    runTime += 1;
                    cache.remove(city);
                    cache.add(city);
                }
                // 미스
                else {
                    cache.remove(0);
                    cache.add(city);
                    runTime += 5;
                }
            }
        }

        return runTime;
    }
}