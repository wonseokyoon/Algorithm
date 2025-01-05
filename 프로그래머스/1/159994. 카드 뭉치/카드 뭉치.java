import java.util.*;
class Solution {
public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> card1=new LinkedList<>();
        Queue<String> card2=new LinkedList<>();
        Queue<String> goals=new LinkedList<>();
        for(String str:cards1){
            card1.offer(str);
        }for(String str:cards2){
            card2.offer(str);
        }for(String str:goal){
            goals.offer(str);
        }
        boolean result=true;
        while(!goals.isEmpty()){
            if(goals.peek().equals(card1.peek())&& !card1.isEmpty()){
                card1.poll();
                goals.poll();
            } else if (goals.peek().equals(card2.peek()) && !card2.isEmpty()) {
                card2.poll();
                goals.poll();
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}