import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[][] edges = {{2, 3}, {4, 3}, {1, 1}, {2, 1}};
        Solution solution = new Solution();
        int[] result = solution.solution(edges);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[][] edges) {
        int N=1000000;
        int[] in=new int[N];    // 들어오는 개수
        int[] out=new int[N];   // 나가는 개수

        for(int[] edge : edges) {
            out[edge[0]]++;
            in[edge[1]]++;
        }

        int vertex=0;
        int dougnut=0;
        int stick=0;
        int eight=0;
        
        for(int i=0; i<N; i++) {
            if(out[i]>=2){
                if(in[i]==0){
                    vertex=i;            
                }else {
                    eight++;
                }
            } else if (out[i]==0 && in[i]>0) {
                stick++;
            }

        }


        int[] answer = {vertex,out[vertex]-stick-eight,stick,eight};
        return answer;
    }
}