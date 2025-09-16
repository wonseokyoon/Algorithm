import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            
            @Override
            public int compare(String a, String b) {
                Integer s1 = Integer.parseInt(a+b);
                Integer s2 = Integer.parseInt(b+a);
                return s2 - s1;                
            }
        });
        
        for(int number : numbers) {
            pq.offer(number+"");
        }
        
        if(pq.peek().equals("0")) return "0";
        
        StringBuilder stringBuilder = new StringBuilder();
        while(!pq.isEmpty()) {
            stringBuilder.append(pq.poll());
        }
        
        return stringBuilder.toString();
    }
}