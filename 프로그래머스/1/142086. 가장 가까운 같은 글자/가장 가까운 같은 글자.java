
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
public int[] solution(String s) {
        ArrayList<Integer> answer=new ArrayList<>();
        char[] str=s.toCharArray();
        int cnt=0;
        ArrayList<Character> exist=new ArrayList<>();
        for(char c:str){
            if(exist.contains(c)){  //앞에 이미 같은 문자가 있는 경우
                for(int i=cnt-1;i>=0;i--){
                    if(str[cnt]==str[i]){
                        answer.add(cnt-i);
                        break;
                    }
                }
            }else {
                exist.add(c);   // 문자 추가
                answer.add(-1); // -1 추가
            }
            cnt++;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}