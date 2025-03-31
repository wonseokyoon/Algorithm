class Solution {
    public String solution(String s) {
        String[] params = s.split(" ",-1);
        StringBuilder result = new StringBuilder();
        for(String param : params) {
            if(!param.isEmpty()){
                char c = param.charAt(0);
                if(Character.isLetter(c)){
                    result.append(Character.toUpperCase(c));
                }else result.append(c);

                for(int i = 1; i < param.length(); i++){
                    c = param.charAt(i);
                    result.append(Character.toLowerCase(c));
                }
            }
            result.append(" ");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
}