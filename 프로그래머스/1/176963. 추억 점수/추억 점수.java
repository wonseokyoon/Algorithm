import java.util.*;
class Solution {
public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i< name.length;i++){
            map.put(name[i],yearning[i]);   // may:5, kein:10 ...
        }

        for(int i=0;i< photo.length;i++){
            int sum=0;
            for(String key:photo[i]){
                sum+=map.getOrDefault(key,0);
            }
            answer[i]=sum;
        }
        return answer;
    }
}