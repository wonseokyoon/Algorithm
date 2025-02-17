class Solution {
public int solution(int n, int w, int num) {
        int h;
        if(n%w==0){
            h=n/w;
        }else{
            h=n/w+1;
        }
        int[][] box=new int[h][w];
        int number=1;
        for(int i=0;i<h;i++){
            if(i%2==0){ // ->
                int j=0;
                while(j<w){
                    box[i][j]=number;
                    j++;
                    number++;
                    if(number>n) break;
                }
            }else{ // <-
                int j=w-1;
                while(j>=0){
                    box[i][j]=number;
                    j--;
                    number++;
                    if(number>n) break;
                }
            }
        }

        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                System.out.print(box[i][j]+ " ");
            }
            System.out.println();
        }

        int row;
        if(num%w==0){
            row=num/w-1;
        }else{
            row=num/w;
        }

        int col;  // 열2
        if(row%2==0){   //  ->
            col=num%w-1;
            if(col==-1){
                col=w-1;
            }
        }else{      // <-
            col=w-num%w;
            if(col==w) col=0;
        }

        int cnt=0;
        for(int i=h-1;i>=0;i--){
            if(box[i][col]==num){
                cnt++;
                return cnt;
            }
            if(box[i][col]!=0){
                cnt++;
            }
        }

        return -1;
    }
}