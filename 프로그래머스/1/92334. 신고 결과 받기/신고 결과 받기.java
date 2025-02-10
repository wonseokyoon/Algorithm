import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 각 사용자가 신고한 사람을 저장하기 위한 Map
        Map<String, Set<String>> reportMap = new HashMap<>();
        // 신고받은 횟수를 세기 위한 Map
        Map<String, Integer> violationCount = new HashMap<>();
        
        // 초기화 (각 id_list 사용자에 대한 Map)
        for (String id : id_list) {
            reportMap.put(id, new HashSet<>()); // 각 유저가 신고한 목록
            violationCount.put(id, 0); // 초기 신고 횟수
        }

        // 보고된 신고를 처리
        for (String r : report) {
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String defendant = parts[1];
            reportMap.get(reporter).add(defendant); // 신고자를 Set에 추가
        }

        // 각 사용자에 대해 신고받은 횟수 계산
        for (String reporter : reportMap.keySet()) {
            for (String defendant : reportMap.get(reporter)) {
                // 신고받은 횟수 증가
                violationCount.put(defendant, violationCount.get(defendant) + 1);
            }
        }

        // 정지된 사용자 목록
        Set<String> suspendedUsers = new HashSet<>();
        for (String id : id_list) {
            if (violationCount.get(id) >= k) {
                suspendedUsers.add(id); // k회 이상 신고된 사용자 추가
            }
        }

        // 최종 결과 생성
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String userId = id_list[i];
            int count = 0;
            // 각 사용자가 신고한 목록을 확인하여 정지된 사용자 수 카운트
            for (String reportedUser : reportMap.get(userId)) {
                if (suspendedUsers.contains(reportedUser)) {
                    count++; // 정지된 사용자일 경우 카운트 증가
                }
            }
            answer[i] = count; // 해당 사용자의 결과 저장
        }

        return answer;
    }
}