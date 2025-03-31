class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] params = s.toLowerCase().split("");
        boolean flag = true;

        for(String param : params) {
            if(flag) {
                sb.append(param.toUpperCase());
            }else{
                sb.append(param);
            }
            flag = param.equals(" ");
        }

        return sb.toString();
    }
}