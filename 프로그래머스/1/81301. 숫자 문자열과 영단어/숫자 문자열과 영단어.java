class Solution {
        public int solution(String s) {
        String[] str={"zero","one","two","three","four","five"
        ,"six","seven","eight","nine"};
        String[] digit={"0","1","2","3","4","5","6","7","8","9"};
        for(int i=0;i<str.length;i++){
            s=s.replaceAll(str[i],digit[i]);
        }
        return Integer.parseInt(s);
    }
}