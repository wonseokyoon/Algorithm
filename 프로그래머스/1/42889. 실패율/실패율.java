import java.util.*;
class Solution {
    public int[] solution(int n, int[] stages) {
        int people=stages.length;   // 게임하는 숫자
        int[] clear=new int[n+1]; // 스테이지별 통과
        clear[0]= people;       // 0번 스테이지는 전원 클리어

        for(int i=1;i<=n;i++){
            for(int j=0;j<people;j++){
                if(stages[j]-1 >= i){
                    clear[i]++;
                }
            }
        }
        // [8, 7, 4, 2, 1, 1] 0번 스테이지부터 통과자(=생존자)

        double[] per=new double[n];
        for(int i=0;i<n;i++){
            if(clear[i]==0){
                per[i]=0;
            }else{
                per[i]=(double)(clear[i]-clear[i+1])/clear[i];
            }
        }

        // [실패율][번호]
        double[][] rates=new double[n][2];
        for(int i=0;i<n;i++){
            rates[i][0]=per[i];
            rates[i][1]=i+1;
        }

        Arrays.sort(rates,(a,b)->{
            if(Double.compare(b[0],a[0])==0){
                return Double.compare(a[1],b[1]);   // 번호순 정렬
            }
            return Double.compare(b[0],a[0]);   // 실패율 내림차순
        });

        int[] answer=new int[n];
        for(int i=0;i<n;i++){
            answer[i]= (int)rates[i][1];
        }
        System.out.println(Arrays.toString(answer));

        return answer;
    }
}