import java.util.*;
class Solution {
    public int[] solution(String s) {
        String[] arr = s.replaceAll("\\{"," ")
                .replaceAll("\\}"," ")
                .trim()
                .split(" , ");

        Arrays.sort(arr, (a,b) -> Integer.compare(a.length(), b.length()));

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(String str : arr){
            for(String num:str.split(",")){
                set.add(Integer.parseInt(num));
            }
        }

        LinkedList<Integer> list = new LinkedList<>(set);
        return list.stream().mapToInt(i->i).toArray();
    }
}