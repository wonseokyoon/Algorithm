import java.util.*;
class Solution {
    public int solution(String s) {
        HashMap<String,Integer> map=new HashMap<>();
        String[] str={"zero","one","two","three","four","five"
        ,"six","seven","eight","nine"};
        for (int i=0;i<10;i++){
            map.put(str[i],i);  // zero:0, one:1, two:2, ...
        }
        StringBuilder sb=new StringBuilder(s);
        for(String key:map.keySet()){
            while(sb.indexOf(key) != -1){
                int idx=sb.indexOf(key);    //대체 문자열의 시작 인덱스
                int value=map.get(key); // value
                sb.replace(idx,idx+key.length(),String.valueOf(value));
            }
        }
        return Integer.parseInt(sb.toString());
    }
}