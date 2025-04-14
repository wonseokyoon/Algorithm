import java.util.*;
class Solution {
public int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;  // 3
        int col = arr2[0].length;   // 2
        int n = arr2.length;
        int[][] result = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                for(int index =0 ; index < n ; index++){
                    result[i][j] += arr1[i][index] * arr2[index][j];
                }
            }
        }

        return result;
    }
}