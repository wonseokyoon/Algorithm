import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        HashMap<Character,Integer> xmap=new HashMap<>();
        HashMap<Character,Integer> ymap=new HashMap<>();
        List<Character> list=new ArrayList<>();
        for(char x:X.toCharArray()){    //'1':1, '0':2
            xmap.put(x,xmap.getOrDefault(x,0)+1);
        }
        for(char y:Y.toCharArray()){
            ymap.put(y,ymap.getOrDefault(y,0)+1);
        }
        for(char c: xmap.keySet()){
            if(ymap.containsKey(c)){
                int count=Math.min(xmap.get(c), ymap.get(c));
                for(int i=0;i<count;i++){
                    list.add(c);
                }
            }
        }

        if(list.isEmpty()){
            return "-1";
        }
        list.sort(Comparator.reverseOrder());
        if(list.get(list.size() - 1).equals('0') && list.get(0).equals('0')){

            return "0";
        }

        StringBuilder result=new StringBuilder();
        for(Character c:list){
            result.append(c);
        }
        return result.toString();
    }
}