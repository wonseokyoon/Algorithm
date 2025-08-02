import java.util.*;

class Solution {
        class User {
        String id;
        String nickname;

        User(String id,String nickname){
            this.id = id;
            this.nickname = nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getNickname() {
            return nickname;
        }
    }

    public String[] solution(String[] record) {
        Map<String, User> map = new HashMap<>();

        for(String str : record) {
            String[] split = str.split(" ",3);
            String type = split[0];
            String id = split[1];
            if(type.equals("Enter")) {
                String nickname = split[2];
                map.put(id, new User(id,nickname));
            } else if (type.equals("Change")) {
                String nickname = split[2];
                map.get(id).setNickname(nickname);  // 닉네임 수정
            }
        }

        ArrayList<String> result = new ArrayList<>();
        for(String str : record) {
            String type = str.split(" ",2)[0];
            String id = str.split(" ",3)[1];

            // 입장,퇴장만 기록
            if(type.equals("Enter")) {
                result.add(map.get(id).getNickname() +"님이 들어왔습니다.");
            } else if (type.equals("Leave")) {
                result.add(map.get(id).getNickname() +"님이 나갔습니다.");
            }
        }
        return result.toArray(new String[0]);
    }
}