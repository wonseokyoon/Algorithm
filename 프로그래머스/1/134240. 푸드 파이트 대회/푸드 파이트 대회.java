class Solution {
     public String solution(int[] food) {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i< food.length;i++){
            int cnt=food[i];
            for(int j=0;j<cnt/2;j++){
                sb.append(i);
            }
        }
        String left=sb.toString();
        sb.reverse();
        String answer=left+"0"+sb;
        return answer;
    }
}