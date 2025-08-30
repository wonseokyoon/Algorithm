import java.util.*;

class Solution {
    public final int[] discounts = {
        10,20,30,40
    };
    int maxCnt = 0;
    int maxPriceSum = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int length = emoticons.length;
        
        // 완전 탐색 시작
        dfs(0,new int[length],users,emoticons);
        
        return new int[]{maxCnt,maxPriceSum};
    }
    
    void dfs(int depth, int[] currentDiscount, int[][] users, int[] emoticons){
        
        if(depth == emoticons.length){
            // 할인율을 적용하여 가입자수와 판매액 계산
            calculateResult(currentDiscount,users,emoticons);
            return;
        }
        
        for(int discount : discounts){
            currentDiscount[depth] = discount;
            dfs(depth+1,currentDiscount,users,emoticons);
        }
    }
    
    void calculateResult(int[] currentDiscount,int[][] users,int[] emoticons){
        int plusCnt = 0;        // 플러스 서비스 구매자 수
        int totalSum = 0;    // 토탈 이모티콘 판매액
        
        for(int[] user: users) {
            int userDiscount = user[0];     // 유저의 할인율 기준
            int userPrice = user[1];        // 유저의 가격 기준
            
            int sum = 0;
            for(int i = 0; i < emoticons.length; i++){
                int rate = currentDiscount[i];  // 해당 이모티콘의 할인율                
                
                if(rate >= userDiscount) {  // 구매
                    sum += emoticons[i] * (100 - rate) / 100;
                }
            }
            if(sum >= userPrice) {  // 구매 총액이 기준을 넘어섰음 -> 플러스 서비스 구매
                plusCnt ++;         // 플러스 서비스 구매자 +1
            } else{ 
                totalSum += sum;    // 토탈 판매액 반영
            }
        }
        
        // 기존보다 서비스 구매가 높으면 교체
        if(plusCnt > maxCnt) {
            maxPriceSum = totalSum;
            maxCnt = plusCnt;
        } else if(plusCnt == maxCnt){
            maxPriceSum = Math.max(totalSum,maxPriceSum);   // 더 큰값
        }         
    }
}