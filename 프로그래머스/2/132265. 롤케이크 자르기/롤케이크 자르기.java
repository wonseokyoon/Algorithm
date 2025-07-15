import java.util.*;
class Solution {
        public int solution(int[] topping) {
        HashMap<Integer,Integer> left = new HashMap<>();
        HashMap<Integer,Integer> right = new HashMap<>();

        int answer = 0;

        // Map을 이용해서 중복 제거와 갯수 카운팅
        for(int i = 0; i < topping.length; i++){
            left.put(topping[i], left.getOrDefault(topping[i], 0) + 1);
        }

        for(int i=topping.length-1; i>=1; i--){     // 반대편에서부터 카운트
            int cur = topping[i];   // 현재 원소
            right.put(cur, right.getOrDefault(cur, 0) + 1); // 오른쪽에 추가
            left.put(cur, left.getOrDefault(cur, 0) - 1);   // 왼쪽에서 제거

            if(left.get(cur) == 0){ // 현재 원소 갯수가 0이면 제거
                left.remove(cur);
            }

            // 토핑 가짓수 비교
            if(left.size() == right.size()){
                answer++;
            }

            if(left.size() < right.size()){
                break;
            }

        }

        return answer;
    }
}