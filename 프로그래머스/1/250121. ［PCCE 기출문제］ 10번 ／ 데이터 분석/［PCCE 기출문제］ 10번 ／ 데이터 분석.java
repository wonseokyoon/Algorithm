import java.util.*;
class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        map.put("code",0);
        map.put("date",1);
        map.put("maximum",2);
        map.put("remain",3);
        int sidx=-1;
        int idx=-1;
        for(String str: map.keySet()){
            if(ext.equals(str)){
                idx=map.get(ext);
            }
            if(sort_by.equals(str)){
                sidx=map.get(str);
            }
        }
        final int sort_idx=sidx;
        for(int i=0;i< data.length;i++){
            if(data[i][idx]<val_ext) list.add(data[i]);
        }
        list.sort((o1,o2)->Integer.compare(o1[sort_idx],o2[sort_idx]));
        return list;
    }
}