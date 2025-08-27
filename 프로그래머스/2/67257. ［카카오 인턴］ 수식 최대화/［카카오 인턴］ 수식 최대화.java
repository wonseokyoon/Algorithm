import java.util.*;
class Solution {
    private final String[][] priorities = {
        {"+","*","-"},{"+","-","*"},
        {"-","*","+"},{"-","+","*"},
        {"*","+","-"},{"*","-","+"}
    };
    
    public long solution(String expression) {
        // 숫자와 부호 저장 리스트
        ArrayList<String> originalList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(char ch : expression.toCharArray()){
            if(ch == '*' || ch == '+' || ch =='-'){
                originalList.add(sb.toString());    // 숫자
                sb.setLength(0);            // 초기화

                sb.append(ch);
                originalList.add(sb.toString());    // 부호
                sb.setLength(0);            // 초기화
            }
            else{
                sb.append(ch);
            }
        }
        originalList.add(sb.toString());
        long answer = 0;
        for(String[] priority : priorities){
            // 복사본
            ArrayList<String> list = new ArrayList<>(originalList);
            for(int i = 0; i< priority.length;i++){
                String sign = priority[i];
                while(list.contains(sign)){
                    // 부호의 인덱스 찾음
                    int idx = list.indexOf(sign);
                    long num1 = Long.parseLong(list.get(idx-1));
                    long num2 = Long.parseLong(list.get(idx+1));
                    
                    // 연산
                    long result = calculate(num1,num2,sign);
                    
                    list.set(idx-1,result+""); // result 주입
                    list.remove(idx);       // 부호 삭제
                    list.remove(idx);       // num2 삭제
                }
            }
            long absResult = Math.abs(Long.parseLong(list.get(0)));
            if(absResult > answer) answer = absResult;
            // System.out.println("연산 후:" + list);
            // System.out.println("최댓값: " + answer);
        }
        return answer;
    }
    
    long calculate(long num1,long num2,String sign){
        switch(sign){
            case("*"):  return num1 * num2; 
            case("+"):  return num1 + num2;
            case("-"):  return num1 - num2;
        }
        return 0;
    }
}