import java.util.ArrayList;
import java.util.List;
class Solution {
    public int solution(String s) {
        int cnt=1;
        int cnt2=0;
        char pre=s.charAt(0);
        List<String> str=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        sb.append(s.charAt(0)); //a
        if(s.length()==1) return 1;
        for(int i=1;i<s.length();i++){
            if(i==s.length()-1){
                sb.append(s.charAt(i));
                str.add(sb.toString());
                break;
            }
            if(pre == '0'){
                pre=s.charAt(i);
                sb.append(pre);
                cnt=1;
                continue;
            }
            if(s.charAt(i)==pre){
                sb.append(s.charAt(i)); //aaabbacc
                cnt++;                  // 2 3 4
            }
            else{
                cnt2++;                 // 1 2 3 4
                if(cnt==cnt2){
                    sb.append(s.charAt(i));
                    str.add(sb.toString());
                    pre='0';
                    cnt2=0;
                    sb.setLength(0);    //초기화
                }else {
                    sb.append(s.charAt(i));
                }
            }

        }
        System.out.println(str);
        return str.size();
    }
}