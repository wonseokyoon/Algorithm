import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0; i < skill_trees.length; i++) {
            int index = 0;
            boolean isValid = true;

            for(char c: skill_trees[i].toCharArray()) {
                // 현재 문자의 스킬 순서 체크
                int check = skill.indexOf(c);
                // 선행 스킬에 포함되지 않는 경우
                if(check == -1) {
                    continue;
                }

                if(index != check){
                    isValid = false;
                    break;
                }
                index++;
            }

            if(isValid) {
                answer++;
            }

        }
        return answer;
    }
}