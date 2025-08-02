import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class Solution {
    public String[] solution(String[] record) {
//        Pattern pattern = Pattern.compile("([a-z\\s.-]+)([0-9]{1,5})");
        Map<String,String> map = new HashMap<>();

        for(String str : record) {
            String[] split = str.split(" ",3);
            String id = split[1];
            if(split.length > 2) {
                String nickname = split[2];
                map.put(id,nickname);
            }

        }

        StringBuilder sb = new StringBuilder();
        for(String str : record) {
            String type = str.split(" ",2)[0];
            String id = str.split(" ",3)[1];

            // 입장,퇴장만 기록
            if(type.equals("Enter")) {
                sb.append(map.get(id));
                sb.append("님이 들어왔습니다.,");
            } else if (type.equals("Leave")) {
                sb.append(map.get(id));
                sb.append("님이 나갔습니다.,");
            }
        }

        return sb.toString().split(",");
    }
}