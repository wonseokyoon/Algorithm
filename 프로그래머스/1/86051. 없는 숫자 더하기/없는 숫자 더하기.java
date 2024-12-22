class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        for(int a=1; a<10; a++){  
            int count = 0;
            for(int s=0; s<numbers.length; s++){
                if(a==numbers[s]){
                    break;   
                }else{
                    ++count;
                }
                if(numbers.length == count){
                  answer += a;  
                }
            }
        }
        return answer;
    }
}
