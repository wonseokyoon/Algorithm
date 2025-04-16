import java.util.*;
class Solution {
public int solution(String[][] clothes) {
        Map<String,Integer> map = new HashMap<>();
        // 종류별로 그룹화 , 기본값:1(아무것도 안입는 경우 포함: +1)
        for(int i=0;i<clothes.length;i++){
            String category = clothes[i][1];
            map.put(category,map.getOrDefault(category,1)+1);
        }

        int answer = 1;
        for(int num:map.values()){
            answer *= num;
        }

        // 모든 종류의 옷을 안입는 경우 -1
        answer--;
        return answer;
    }
}