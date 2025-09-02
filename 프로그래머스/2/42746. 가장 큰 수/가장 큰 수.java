import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 사전 순 정렬
        ArrayList<String> strList = new ArrayList<>();
        for(int number : numbers){
            strList.add(String.valueOf(number));
        }
        Collections.sort(strList,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                int num1 = Integer.parseInt(s1+s2);
                int num2 = Integer.parseInt(s2+s1);
                
                return num2 - num1;
            }
            
        });
        
        StringBuilder stringBuilder = new StringBuilder();
        for(String str : strList){
            stringBuilder.append(str);
        }
        if(stringBuilder.toString().startsWith("0")) return "0";
        return stringBuilder.toString();
    }
}