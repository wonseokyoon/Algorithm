import java.util.ArrayList;
import java.util.List;
class Solution {
    public int solution(String s) {
        char prev='1';
        int same=0,different=0,answer=0;
        for(char c:s.toCharArray()){
            if(prev=='1'){  //최초 문자
                prev=c;
                same++;
                answer++;
            }else if(prev==c){  //이전 문자랑 같을 경우
                same++;
            }else {     //이전 문자랑 다를 경우
                different++;
            }
            
            if(same==different){
                prev='1';
                same=0;
                different=0;
            }
        }
        
        return answer;
        
    }
}