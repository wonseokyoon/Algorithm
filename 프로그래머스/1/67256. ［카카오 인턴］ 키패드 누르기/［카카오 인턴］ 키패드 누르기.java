class Solution {
    public String solution(int[] numbers,String hand) {
        StringBuilder sb=new StringBuilder();
        int[] lf={3,1};
        int[] rf={3,3};
        int dlf=0;
        int drf=0;
        for(int i=0;i< numbers.length;i++){
            int row=numbers[i]/3;
            int col=numbers[i]%3;
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                lf[0]=row;
                lf[1]=col;
                sb.append("L");
            } else if (numbers[i]==9 || numbers[i]==6 || numbers[i]==3) {
                row-=1;
                col=3;
                rf[0]=row;
                rf[1]=col;
                sb.append("R");
            }
            else{  //2 5 8 0
                if(numbers[i]==0){
                    row=3;
                    col=2;
                }
                dlf=(Math.abs(row-lf[0]) + Math.abs(col-lf[1]));
                drf=(Math.abs(row-rf[0]) + Math.abs(col-rf[1]));
                if(dlf>drf){    // 오른손 무빙
                    rf[0]=row;
                    rf[1]=col;
                    sb.append("R");
                } else if (dlf<drf) { //왼손 무빙
                    lf[0]=row;
                    lf[1]=col;
                    sb.append("L");
                }else{
                    if(hand.equals("right")){
                        rf[0]=row;
                        rf[1]=col;
                        sb.append("R");
                    }else{
                        lf[0]=row;
                        lf[1]=col;
                        sb.append("L");
                    }
                }
            }
        }
        return sb.toString();

    }
}