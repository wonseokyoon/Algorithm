class Solution {
    public String solution(int n) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<5000;i++){
            sb.append("수박");
        }
        
        String answer = sb.toString().substring(0,n);
        return answer;
    }
}