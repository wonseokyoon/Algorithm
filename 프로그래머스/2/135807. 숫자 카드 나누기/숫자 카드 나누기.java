import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        
        // 정렬
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int a = arrayA[0];
        int b = arrayB[0];
        
        int curNum = 2;
        int maxA = 0;
        while(curNum <= a){
            // A의 모든 숫자를 나누고 B의 모든 숫자를 못나눔
            if(canDivisionAll(curNum,arrayA) && cantDivisionAny(curNum,arrayB)) {
                maxA = curNum;
            }
            curNum ++;
        }
        
        curNum = 2;
        int maxB = 0;
        while(curNum <= b){
            // B의 모든 숫자를 나누고 A의 모든 숫자를 못나눔
            if(canDivisionAll(curNum,arrayB) && cantDivisionAny(curNum,arrayA)){
                maxB = curNum;
            }
            curNum ++;
        }
        
        return Math.max(maxA,maxB);
    }
    
    // 모든 숫자를 나눌 수 있음
    boolean canDivisionAll(int number,int[] array){
        for(int i=0;i<array.length; i++){
            int number2 = array[i];
            if(number2%number != 0){
                return false;
            }
        }
        return true;
    }
    
    // 어느 숫자도 못나눔
    boolean cantDivisionAny(int number,int[] array){
        for(int i=0;i<array.length; i++){
            int number2 = array[i];
            if(number2%number == 0){
                return false;
            }
        }
        return true;
    }
}