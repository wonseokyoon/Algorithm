import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        // 각 노드의 들어오는 간선 수와 나가는 간선 수를 저장할 맵
        Map<Integer, int[]> nodes = new HashMap<>();
        
        // 추가된 노드, 도넛, 막대, 8자그래프 개수
        int extraNode = -1; 
        int doughnut = 0; 
        int stick = 0; 
        int figure8 = 0;

        // 1단계: 각 노드의 간선 개수를 계산
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            // 노드 개수 초기화
            nodes.putIfAbsent(from, new int[]{0, 0});
            nodes.putIfAbsent(to, new int[]{0, 0});

            // 나가는 간선 수 증가
            nodes.get(from)[0]++;
            // 들어오는 간선 수 증가
            nodes.get(to)[1]++;
        }

        // 2단계: 각 노드 탐색하여 그래프 유형 판단
        for (int key : nodes.keySet()) {
            int[] count = nodes.get(key);

            // 나가는 간선이 2개 이상이고, 들어오는 간선이 없으면 생성한 정점
            if (count[0] >= 2 && count[1] == 0) {
                extraNode = key; 
            }
            // 나가는 간선이 없고, 들어오는 간선이 있을 경우 = 막대 그래프
            else if (count[0] == 0 && count[1] > 0) {
                stick++;
            }
            // 들어오는 것과 나가는 것이 각 2개 이상일 경우 = 8자 그래프
            else if (count[0] >= 2 && count[1] >= 2) {
                figure8++;
            }
        }

        // 도넛 그래프의 개수는 생성한 노드에서 나가는 간선 수에서 stick과 figure8을 빼서 계산
        if (extraNode != -1) {
            int totalOutgoingEdges = nodes.get(extraNode)[0];
            doughnut = totalOutgoingEdges - stick - figure8;
        }

        return new int[]{extraNode, doughnut, stick, figure8};
    }
}