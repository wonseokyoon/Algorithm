class Solution {
    public String solution(String s) {
        StringBuilder result=new StringBuilder();
        String[] str=s.split(" ",-1);  //try, hello, world
        for(String word: str) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (i % 2 == 0) { //짝수: 대문자로
                    sb.append(Character.toUpperCase(c));
                }else{
                    sb.append(Character.toLowerCase(c));
                }
            }
            result.append(sb).append(" ");
        }
                result.deleteCharAt(result.length()-1); //마지막 " " 제거

        return result.toString();
    }
}