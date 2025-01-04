import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String s=Integer.toBinaryString(30);

        for(int i=0;i<n;i++){
            StringBuilder temp=new StringBuilder();
            String sb1=Integer.toBinaryString(arr1[i]);
            String sb2=Integer.toBinaryString(arr2[i]);

            // 두 이진 문자열 길이 맞추기 위해 패딩
            while(sb1.length()<n){
                sb1="0"+sb1;
            }
            while(sb2.length()<n){
                sb2="0"+sb2;
            }

            for(int j=0;j< sb1.length();j++){
                if(sb1.charAt(j)=='1' || sb2.charAt(j)=='1'){
                    temp.append('#');
                }
                else{
                    temp.append(' ');
                }
            }


            answer[i]=temp.toString();
        }


        return answer;
    }
}