import java.util.Arrays;
class Solution {
    public String solution(String[] seoul) {
        int x=Arrays.asList(seoul).indexOf("Kim");  //Kim의 인덱스 탐색
        return "김서방은 " + x + "에 있다";
    }
}