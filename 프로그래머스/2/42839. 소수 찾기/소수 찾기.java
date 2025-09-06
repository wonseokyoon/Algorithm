import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    boolean[] visited;
    public int solution(String numbers) {
        int len = numbers.length();
        visited = new boolean[len];
        
        // 1. 종이를 먼저 뭉침
        char[] nums = numbers.toCharArray();
        dfs(new StringBuilder(),0,nums);
        System.out.println(set);
        System.out.println(set.size());
        
        // 2. 소수인지 판별
        
        int answer = 0;
        for(int number : set) {
            
            if(isPrime(number)) answer ++;
        }
        return answer;
    }
    
    void dfs(StringBuilder current,int length, char[] numbers){
        
        
        if(length > 0 && length <= numbers.length) {
            int num = Integer.parseInt(current.toString());
            set.add(num);    // set에 등록
            
            if(length == numbers.length) return;
        }
        
        
        for(int i = 0; i < numbers.length; i++) {
            if(!visited[i]){
                visited[i] = true;  // 방문 처리
                dfs(current.append(numbers[i]), length + 1, numbers);
                current.setLength(length);  // 백트래킹
                visited[i] = false;
            }
        }
    }
    
    boolean isPrime(int number){
        if(number == 1 || number == 0) return false;
        
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}