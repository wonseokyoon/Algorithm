import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int[] target={1,2,3,1};
        //2, 1, 1, 2, 3, 1, 2, 3, 1}
        ArrayList<Integer> list=new ArrayList<>
                (Arrays.asList(Arrays.stream(ingredient)
                        .boxed().toArray(Integer[]::new)));
        int cnt=0;
        int index=0;

        while(index<=list.size()- target.length){
            if(isTarget(list,target,index)){
                extractTarget(list,target,index);
                cnt++;
                index=Math.max(0,index-target.length);
            }else{
                index++;
            }
        }

        return cnt;
    }

    private void extractTarget(ArrayList<Integer> list,int[] target,int start) {
        for (int i=0;i<target.length;i++){
            list.remove(start);
        }
    }

    public static boolean isTarget(ArrayList<Integer> array,int[] target,int start){
        for(int i=0;i< target.length;i++){
            if(array.get(start+i)!=target[i]){
                return false;
            }
        }
        return true;
    }
}