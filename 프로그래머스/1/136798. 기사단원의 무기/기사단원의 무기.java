import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        // 15 -> 약수:1,3,5,15 -> 공격력 4짜리 무기 구매(단, 제한 존재)
        // 공격력 1당 1Kg 철 필요
        
        // number: 기사 단원 수
        // limit: 공격력 제한 수치
        // power: 제한 수치를 초과한 기사가 사용할 공격력
        // 필요한 철의 무게 return
        
        // 1. 1부터 number까지 약수의 갯수를 구함
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=number;i++){
            // 1. 1부터 number까지 약수의 갯수를 구함
            int count = getCount(i);
            // 2. 약수의 갯수가 limit을 초과하는지 확인
            if(count > limit){
                // 3. 만약에 limit보다 크다면 power를 리스트에 등록                
                list.add(power);
                continue;
            }
            list.add(count);
        }
        // 4. list의 합 return
        int sum = list.stream()
            .mapToInt(Integer::intValue)
            .sum();
        return sum;
    }
    
    int getCount(int number){
        if(number == 1){
            return 1;
        }
        
        int sqrt = (int) Math.sqrt(number);
        int count = 0;
        
        for(int i=1;i <= sqrt;i++){
            if(i*i == number){
                count++;
            }
            else if(number % i == 0){
                count+=2;
            }
        }
        
        return count;
    }
}