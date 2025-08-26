import java.util.*;
class Solution {
    
    Map<String,Integer> map = new HashMap<>();
    ArrayList<String> answerList = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        for(int length:course){

            // Course에 해당하는 조합        
            for(String order:orders){
                char[] ch = order.toCharArray();
                
                // 사전순 정렬
                Arrays.sort(ch);
                
                // 조합을 찾아서 몇번 주문됐는지 기록
                findCombo(ch,0,length,new StringBuilder());
            }
            if(!map.isEmpty()){
                int maxValue = map.values().stream()
                    .mapToInt(Integer::intValue)
                    .max()
                    .orElse(0);
                
                if(maxValue >= 2){
                    for(String key:map.keySet()){
                        // 최댓값
                        if(map.get(key) == maxValue){
                            answerList.add(key);
                        }
                    }
                }
            }
            // map을 비움
            map.clear();
        }
        Collections.sort(answerList);
        return answerList.toArray(String[]::new);
    }

    void findCombo(char[] order, int startIdx, int length, StringBuilder current){
        
        if(current.length() == length){
            String combo = current.toString();
            map.put(combo,map.getOrDefault(combo,0) +1);
            return;
        }
        
        for(int i = startIdx; i<order.length;i++){
            current.append(order[i]);
            findCombo(order,i+1,length,current);
            current.deleteCharAt(current.length()-1);
        }
    }
}