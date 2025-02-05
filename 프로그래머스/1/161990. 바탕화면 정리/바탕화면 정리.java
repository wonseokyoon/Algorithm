import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int min_row= wallpaper.length;  //시작점 x값
        int min_col= wallpaper[0].length();     //시작점 y값
        int max_row=0;  //종점 x값
        int max_col=0;  //종점 y값
        //(min_row,min_col,max_row,max_col)
        for(int i=0;i<wallpaper.length;i++){
            String temp=wallpaper[i];
            for(int j=0;j<temp.length();j++){
                if(temp.charAt(j) == '#'){
                    min_row=Math.min(i,min_row);
                    min_col=Math.min(j,min_col);
                    max_row=Math.max(i+1,max_row);
                    max_col=Math.max(j+1,max_col);
                }
            }
        }
        int[] result={min_row,min_col,max_row,max_col};
        return result;
    }
}