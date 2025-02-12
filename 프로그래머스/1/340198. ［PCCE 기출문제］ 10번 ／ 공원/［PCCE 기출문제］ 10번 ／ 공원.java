import java.util.*;
class Solution {
    public boolean check(int row,int col,int size,String[][] park){
        int x= park.length;
        int y= park[0].length;

        if(row+size>x||col+size>y){
            return false;
        }

        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(!park[i][j].equals("-1")){
                    return false;
                }
            }
        }
        return true;

    }
    public int solution(int[] mats, String[][] park) {
        int row = park.length;    // 행
        int col = park[0].length; // 열
        Arrays.sort(mats);
        int answer=-1;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(park[i][j].equals("-1")){

                    for(int matSize:mats){
                        if(check(i,j,matSize,park)){ // 돗자리 들어가는지
                            answer=Math.max(matSize,answer);
                        }
                    }


                }
            }
        }
        return answer;
    }
}