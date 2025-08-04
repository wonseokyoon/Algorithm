import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 문자열 배열로 변환
        String[] numbersString = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        // 정렬
        Arrays.sort(numbersString, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        // 내림차순 정렬
                        return (o2+o1).compareTo(o1+o2);
                    }
                }
        );
        
        if(numbersString[0].equals("0")) return "0";


        StringBuilder result = new StringBuilder();
        for(String number : numbersString) {
            result.append(number);
        }
        return result.toString();
    }
}