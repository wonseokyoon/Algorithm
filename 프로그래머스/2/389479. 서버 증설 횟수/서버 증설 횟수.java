import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        List<Integer[]> lifeTimes = new ArrayList<>();

        int currentServer = 1;
        int answer = 0;
        for (int player: players) {
            Iterator<Integer[]> iterator = lifeTimes.iterator();

            while (iterator.hasNext()) {
                Integer[] next = iterator.next();
                int plusServer = next[0];
                int life = --next[1];


                // 수명이 다하면
                if(life == 0) {
                    iterator.remove();  // 지움
                    currentServer -= plusServer;  // 수명이 다한 서버 갯수
                }
            }

            int capacity = currentServer * m;   // 수용 인원
            int addedServer = 0;    // 더해지는 서버 갯수

            // 수용인원보다 많은 경우 -> 증설
            while (player >= capacity) {
                addedServer++;
                currentServer++;
                capacity = currentServer * m;
                answer++;
            }

            if(addedServer > 0){
                lifeTimes.add(new Integer[]{addedServer, k});
            }
        }


        return answer;
    }
}