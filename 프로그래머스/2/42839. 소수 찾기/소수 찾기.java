import java.util.*;
class Solution {
// 중복 방지
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    public int solution(String numbers) {
        char[] num = numbers.toCharArray();
        visited = new boolean[num.length];

        for(int i =1 ; i <= num.length ; i++){
            premutation(num,"",i);
        }

        int count = 0;
        for(int number: set){
            if(isPrime(number)){
                count++;
            }
        }

        return count;
    }

    private boolean isPrime(int number) {
        if(number<=1){
            return false;
        }
        for(int i=2 ; i <= Math.sqrt(number) ; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    private void premutation(char[] num, String current, int maxLength) {
        if(current.length() == maxLength) {
            set.add(Integer.parseInt(current));
            return;
        }

        for(int i = 0 ; i < num.length ; i++){
            if(visited[i] == false){
                visited[i] = true;
                premutation(num,current + num[i],maxLength);
                visited[i] = false;
            }
        }


    }
}