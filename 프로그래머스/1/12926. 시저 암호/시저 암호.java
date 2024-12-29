class Solution {
    //소문자: 97~122
    //대문자: 65~90
    public String solution(String s, int n) {
        int ascii;
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){    //ABZ
            ascii=(int)c;   //아스키코드
            if(Character.isUpperCase(c)){   //대문자
                if(ascii+n>90){ // 범위를 벗어나는 경우
                    ascii=ascii+n-26;
                    c=(char)ascii;   // 문자로 변환
                }
                else{
                    ascii+=n;
                    c=(char)ascii;
                }
            }
            else if(Character.isLowerCase(c)){   //소문자
                if(ascii+n>122){
                    ascii=ascii+n-26;
                    c=(char)ascii;
                }
                else{
                    ascii+=n;
                    c=(char)ascii;
                }
            }
            sb.append(c);
        }

        return sb.toString();
    }
}