class Solution {
    public boolean solution(String s) {
       char[] c=s.toCharArray();
        if(s.length()!=4 && s.length()!=6){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(!Character.isDigit(c[i])){
                return false;
            }
        }
        return true;


    }
}