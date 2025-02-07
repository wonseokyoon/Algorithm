import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String,Integer> map=new HashMap<>();

        for(int i=0;i<players.length;i++){
            map.put(players[i],i);
        }

        for(String calling:callings) {
            int index=map.get(calling);     // 3
            if(index>0){
                String previous=players[index-1];       // poe

                players[index-1]=calling;
                players[index]=previous;

                map.put(calling,index-1);
                map.put(previous,index);
            }
        }

        return players;
    }
}