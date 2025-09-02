import java.util.*;
class Solution {
    class Status{
        private int price;
        private int idx;
        
        public Status(int price, int idx){
            this.price = price;
            this.idx = idx;
        }
        
        @Override
        public String toString(){
            return "[" + this.price + "," + this.idx +"]";
        }
    }
    
    public int[] solution(int[] prices) {
        Stack<Status> stack = new Stack<>();
        int len = prices.length;
        int[] answer = new int[len];
        
        for(int i =0; i < len ; i++){
            int price = prices[i];
            Status status = new Status(price,i);
            if(stack.isEmpty()){
                stack.push(status);  
            } else {
                while(true) {
                    if(stack.isEmpty()){ 
                        stack.push(status);  // 추가
                        break;
                    } 
                    Status storedStaus = stack.peek();
                    int storedPrice = storedStaus.price;
                    int storedIdx = storedStaus.idx;
                    
                    // 새로운 값이 더 작을 때
                    if(storedPrice > price) {
                        answer[storedIdx] = i - storedIdx;
                        stack.pop();    // 제거
                    } else{
                        stack.push(status);  // 추가
                        break;
                    }
                }    
            }
        }
        
        // 찌꺼기 처리
        while(!stack.isEmpty()){
            Status storedStaus = stack.pop();
            int storedPrice = storedStaus.price;
            int storedIdx = storedStaus.idx;
            
            answer[storedIdx] = len - 1 - storedIdx;
        }
        
        return answer;
    }
}