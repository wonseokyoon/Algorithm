import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero=0;
        int cnt=0;
        for(int lotto:lottos){
            if(lotto==0) zero++;
        }

        for(int win:win_nums){
            if(Arrays.stream(lottos).anyMatch(n->n==win)){
                cnt++;
            }
        }
        int hope;
        switch (cnt+zero){
            case 6:
                hope=1;
                break;
            case 5:
                hope=2;
                break;
            case 4:
                hope=3;
                break;
            case 3:
                hope=4;
                break;
            case 2:
                hope=5;
                break;
            default:
                hope=6;
                break;
        }
        int real=hope+zero;
        if(real>6) real=6;

        int[] answer={hope,real};
        return answer;
    }
}