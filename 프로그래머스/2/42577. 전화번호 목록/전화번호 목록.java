import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        String[] answer = new String[phone_book.length];
        int i =0;
        for(String number : phone_book){
            answer[i++] = number.replaceAll(" ","");
        }
        Arrays.sort(answer);
        
        for(int idx = 1;idx < answer.length;idx++) {
            String period = answer[idx-1];
            String current = answer[idx];
            
            if(current.startsWith(period)){
                return false;
            }
        }
        return true;
    }
}