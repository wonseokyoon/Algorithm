import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<String,Integer> map=new HashMap<>();

        for(int i=0;i< survey.length;i++){
            // TR, RT, TR
            String str1=survey[i].split("")[0];
            String str2=survey[i].split("")[1];
            if(choices[i]>=4){
                int value=choices[i]-4;
                map.put(str2,map.getOrDefault(str2,0)+value);
            }else{
                int value=4-choices[i];
                map.put(str1,map.getOrDefault(str1,0)+value);
            }
        }

        StringBuilder sb=new StringBuilder();
        sb.append(map.getOrDefault("R",0)>=map.getOrDefault("T",0)?"R":"T")
                .append(map.getOrDefault("C",0)>=map.getOrDefault("F",0)?"C":"F")
                .append(map.getOrDefault("J",0)>=map.getOrDefault("M",0)?"J":"M")
                .append(map.getOrDefault("A",0)>=map.getOrDefault("N",0)?"A":"N");

        return sb.toString();
    }
}