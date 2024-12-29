class Solution {
    public String solution(String s, int n) {
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){    //ABZ
            if(Character.isUpperCase(c)){   //대문자
               c=(char)((c-'A'+n)%26+'A');
            }
            else if(Character.isLowerCase(c)){   //소문자
                c=(char)((c-'a'+n)%26+'a');
            }
            sb.append(c);
        }

        return sb.toString();
    }
}