import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        // 대소문자 구분 x
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // str1의 부분 문자열을 저장 할 배열
        ArrayList<String> strArr1 = new ArrayList<>();
        String subString;
        for(int i=0; i<str1.length()-1; i++) {
            subString = str1.substring(i, i+2);
            // 특수문자가 체크
            boolean flag = true;
            for(char c : subString.toCharArray()) {
                if(!Character.isLetter(c)){
                    flag = false;
                    break;
                }
            }
            // 특수문자가 없는 경우만 추가
            if(flag) strArr1.add(subString);
        }
        // str2의 부분 문자열을 저장 할 배열
        ArrayList<String> strArr2 = new ArrayList<>();
        for(int i=0; i<str2.length()-1; i++) {
            subString = str2.substring(i, i+2);
            // 특수문자가 체크
            boolean flag = true;
            for(char c : subString.toCharArray()) {
                if(!Character.isLetter(c)){
                    flag = false;
                    break;
                }
            }
            if(flag) strArr2.add(subString);
        }

        int interCnt = intersection(strArr1,strArr2);
        int unionCnt = union(strArr1,strArr2);
        if(unionCnt==0) return 65536;

        double jakad = (double) interCnt / unionCnt;

        return (int) Math.floor(jakad * 65536);
    }

    // 교집합 갯수 확인
    private int intersection(ArrayList<String> strArr1, ArrayList<String> strArr2) {
        int interCnt = 0;
        boolean[] used = new boolean[strArr2.size()];   // str2에서 사용한 문자열 체크

        for(String str1 : strArr1) {
            for(int i=0; i<strArr2.size(); i++) {
                if(!used[i] && strArr2.get(i).equals(str1)) {
                    used[i] = true;     // 중복 체크
                    interCnt++;
                    break;
                }
            }
        }
        return interCnt;
    }

    // 합집합 갯수 확인
    private int union(ArrayList<String> strArr1, ArrayList<String> strArr2) {
        Map<String,Integer> countMap1 = new HashMap<>();
        Map<String,Integer> countMap2 = new HashMap<>();
        int unionCnt = 0;

        for(String str1 : strArr1) {
            countMap1.put(str1,countMap1.getOrDefault(str1,0) + 1);
            unionCnt++;
        }
        for(String str2 : strArr2) {
            countMap2.put(str2,countMap2.getOrDefault(str2,0) + 1);
        }

        for(String key : countMap2.keySet()){
            int count1 = countMap1.getOrDefault(key,0);
            int count2 = countMap2.get(key);
            if(count1 < count2){
                unionCnt+=count2-count1;
            }
        }

        return unionCnt;
    }
}