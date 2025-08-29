import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        // 우박 수열
        int n = 0;  // 횟수
        System.out.println(n+":"+k);
        ArrayList<Double> extentList = new ArrayList<>();
        int period;
        while(k>1){
            period = k;
            if(k % 2 == 1) {    // 홀수
                k = k * 3 + 1;
            } else{ // 짝수
                k /= 2;
            }
            n++;
            double extent =  (k + period) / 2.0;
            extentList.add(extent);
            System.out.println(n+":"+k);
            System.out.println("넓이: " + extent);
        }
        System.out.println("넓이 리스트: " + extentList);
        
        int size = ranges.length;
        double[] answer = new double[size];
        
        for(int i=0; i<size; i++){
            int[] range = ranges[i];
            int from = range[0];
            int to = n + range[1];
            double extent = 0.0;
            
            if(from > to){
                answer[i] = -1.0;
            } else if(from == to){
                extent = 0.0;                
            } else{
                
                for(int j = from; j<to;j++){
                    extent += extentList.get(j);
                }
                answer[i] = extent;
            }
        }
        
        return answer;
    }
}