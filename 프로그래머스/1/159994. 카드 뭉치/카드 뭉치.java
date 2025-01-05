import java.util.*;
class Solution {
public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayList<String> card1=new ArrayList<>(Arrays.asList(cards1));
        ArrayList<String> card2=new ArrayList<>(Arrays.asList(cards2));

        boolean result=true;
        for(int i=0;i< goal.length;i++){
            if(!card1.isEmpty()&&goal[i].equals(card1.get(0))){
                card1.remove(0);
            } else if (!card2.isEmpty()&&goal[i].equals(card2.get(0))) {
                card2.remove(0);
            }else{
                result=false;
                break;
            }
        }

        return result?"Yes":"No";
    }
}