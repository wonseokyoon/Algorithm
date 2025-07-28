import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
       ArrayList<String> list = new ArrayList<>(Arrays.asList(skill_trees));
       Iterator<String> iterator = list.iterator();

       while(iterator.hasNext()) {
           // 스킬 순서에 등록된 스킬 제외 전부 지움
           String filtered = iterator.next().replaceAll("[^"+skill+"]","");
           // 순서대로 안나오면 지움
           if(skill.indexOf(filtered) != 0){
               iterator.remove();
           }
       }

       return list.size();
    }
}