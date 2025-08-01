import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Solution {
    public String[] solution(String[] files) {
        Pattern pattern = Pattern.compile("([a-z\\s.-]+)([0-9]{1,5})");

        Arrays.sort(files,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // Mathcher 객체 생성(대소문자 구분x)
                Matcher matcher1 = pattern.matcher(o1.toLowerCase());
                Matcher matcher2 = pattern.matcher(o2.toLowerCase());

                // 스캔
                matcher1.find();
                matcher2.find();

                // 헤더가 다른 경우
                if(!matcher1.group(1).equals(matcher2.group(1))){
                    return matcher1.group(1).compareTo(matcher2.group(1));
                }

                // Number로 정렬
                return Integer.parseInt(matcher1.group(2)) - Integer.parseInt(matcher2.group(2));
            }
        });
        return files;
    }
}