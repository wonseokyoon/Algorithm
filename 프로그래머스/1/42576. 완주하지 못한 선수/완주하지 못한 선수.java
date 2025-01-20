import java.util.HashMap;

class Solution {
     public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map=new HashMap<>();
        for(String str:participant){
            map.put(str,map.getOrDefault(str,0)+1);
        }

        for(String name:completion){
            map.put(name,map.get(name)-1);
        }
        for(String name:map.keySet()){
            if(map.get(name)>0){
                return name;
            }
        }
        return "";
    }
}