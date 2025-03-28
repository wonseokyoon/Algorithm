import java.util.*;

class Solution {
    public String solution(String s) {
        String[] params = s.split(" ");
        int[] arrInt = new int[params.length];
        int i = 0;
        for(String param : params){
            arrInt[i++] = Integer.parseInt(param);
        }

        StringBuilder sb = new StringBuilder();

        sb.append(Arrays.stream(arrInt).min().getAsInt());
        sb.append(" ");
        sb.append(Arrays.stream(arrInt).max().getAsInt());

        return sb.toString();
    }
}