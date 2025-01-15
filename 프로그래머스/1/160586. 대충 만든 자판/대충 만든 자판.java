import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        List<Integer> answer=new ArrayList<>();
        for(String target:targets){     //ABCD
            List<Integer> minList=new ArrayList<>();
            for(char c:target.toCharArray()){   //A
                int min=-1;
                int[] cnt=new int[keymap.length];

                for(int i=0;i< cnt.length;i++){
                    if(keymap[i].contains(String.valueOf(c))){
                        cnt[i]=keymap[i].indexOf(c)+1;
                    }else{
                        cnt[i]=-1;
                    }
                    //System.out.print(cnt[i]+", ");
                }

                min=Arrays.stream(cnt).filter(i->i!=-1)
                        .min()
                        .orElse(-1);
                //System.out.println("-> "+min);
                minList.add(min);
            }
            //System.out.println(minList);

            if(minList.contains(-1)){
                answer.add(-1);
            }else{
                answer.add(minList.stream()
                        .mapToInt(Integer::intValue)
                        .sum());
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}