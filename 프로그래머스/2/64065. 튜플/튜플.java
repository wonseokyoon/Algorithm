import java.util.*;
class Solution {
    public int[] solution(String s) {
        String trimmed = s.substring(2, s.length() - 2);
        String[] param = trimmed.split("},\\{");

        Arrays.sort(param,(a,b) -> Integer.compare(a.length(), b.length()));

        LinkedHashSet<Integer> nums = new LinkedHashSet<>();
        for(int i = 0; i < param.length; i++){
            String[] num = param[i].split(",");
            for(int j = 0; j < num.length; j++){
                nums.add(Integer.parseInt(num[j]));
            }
        }

        ArrayList<Integer> list = new ArrayList<>(nums);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}