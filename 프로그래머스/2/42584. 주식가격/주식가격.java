import java.util.*;

class Solution {
    class Stock {
        private int time;
        private int price;
        
        public Stock(int price, int time) {
            this.price = price;
            this.time = time;
        }
    }
    
    public int[] solution(int[] prices) {
        Stack<Stock> stack = new Stack<>();
        int[] answer = new int[prices.length];
        
        for(int currentTime = 0; currentTime < prices.length; currentTime ++) {
            int price = prices[currentTime];

            while(!stack.isEmpty()) {
                // 가격이 떨어졌다면
                if(stack.peek().price > price){
                    Stock stock = stack.pop();
                    answer[stock.time] = currentTime - stock.time;
                } else break;
            }
            stack.push(new Stock(price,currentTime));
        }
        
        
        while(!stack.isEmpty()) {
            Stock stock = stack.pop();
            answer[stock.time] = prices.length - 1 - stock.time;
        }
        
        return answer;
    }
}