import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        Arrays.sort(data,(a,b) -> {
            if(a[col-1] == b[col-1]){
                return b[0] - a[0];         // 첫뻔재 컬럼을 기준으로 내림차 정렬 
            } else{
                return a[col-1] - b[col-1];         // col-1 컬럼을 기준으로 오름차 정렬 
            }
        });
        
        ArrayList<Integer> siList = new ArrayList<>();
        for(int i=row_begin-1;i<=row_end-1;i++){
            int[] d = data[i];
            int si = calSI(d,i+1);
            System.out.println("si: "+si);
            siList.add(si);
        }
        int answer = siList.get(0);
        for(int i=1;i<siList.size();i++){
            answer ^= siList.get(i);
        }
        
        return answer;
    }
    
    int calSI(int[] datas,int row) {
        int sum =0;
        for(int data : datas){
            sum += data % row;         
        }
        return sum;
    }
}