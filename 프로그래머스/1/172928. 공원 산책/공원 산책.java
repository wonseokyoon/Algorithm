import java.util.*;
class Solution {
        public int[] solution(String[] park, String[] routes) {
        int heiht=park.length;  // 세로
        int width=park[0].length(); // 가로
        int[] location=new int[2];  // 현재 위치
        for(int i=0;i<heiht;i++){
            for(int j=0;j<width;j++){
                if(park[i].charAt(j)=='S'){
                    location[0]=i;  // x좌표
                    location[1]=j;  // y좌표
                    break;
                }
            }
        }

        for(String route:routes){
            boolean canMove=true;
            String direction=route.split(" ")[0];   // 방향
            int distance= Integer.parseInt(route.split(" ")[1]);    // 거리
            int nextRow=location[0];    // x
            int nextCol=location[1];    // y

            for(int i=0;i<distance;i++){
                if(direction.equals("E")){              // 동
                    nextCol++;
                    if(nextCol >= width || park[nextRow].charAt(nextCol)=='X') {
                        canMove=false;
                        break;
                    }
                }else if(direction.equals("W")){        // 서
                    nextCol--;
                    if(nextCol < 0 || park[nextRow].charAt(nextCol)=='X') {
                        canMove=false;
                        break;
                    }
                }else if(direction.equals("S")){        // 남
                    nextRow++;
                    if(nextRow >= heiht || park[nextRow].charAt(nextCol)=='X') {
                        canMove=false;
                        break;
                    }
                } else if (direction.equals("N")) {     // 북
                    nextRow--;
                    if(nextRow < 0 || park[nextRow].charAt(nextCol)=='X') {
                        canMove=false;
                        break;
                    }
                }
            }

            if(canMove){
                location[0]=nextRow;
                location[1]=nextCol;
            }

        }
        return location;
    }
}