import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int totalPicks = Arrays.stream(picks).sum();
        
        int length = minerals.length;
        ArrayList<int[]> mine = new ArrayList<>();
        for(int i = 0; i < length && i < 5 * totalPicks ; i+=5){
            int dia =0 ,iron =0 ,stone = 0;
            for(int j =i; j < i+5 && j < length; j++){
                String mineral = minerals[j];
                if(mineral.equals("diamond")) dia++;
                if(mineral.equals("iron")) iron++;
                if(mineral.equals("stone")) stone++;
            }
            
            mine.add(new int[]{dia,iron,stone});
        }
        
        // 힘든 순서대로 정렬
        Collections.sort(mine,new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                int sumA = a[0] * 25 + a[1] * 5 + a[2] * 1;
                int sumB = b[0] * 25 + b[1] * 5 + b[2] * 1;
                return sumB - sumA;     // 내림차순 정렬
            }
        });
        
        int stemina = 0;
        for(int[] mineral : mine) {
            int dia = mineral[0];
            int iron = mineral[1];
            int stone = mineral[2];
            
            if(picks[0] > 0) {   // 다이아 곡괭이 남아있으면
                stemina += dia * 1;
                stemina += iron * 1; 
                stemina += stone * 1;
                picks[0]--;
            } else if(picks[1] > 0) {   // 철 곡괭이 남아 있으면
                stemina += dia * 5;
                stemina += iron * 1; 
                stemina += stone * 1;
                picks[1]--;
                
            } else{                     // 돌 곡괭이 사용
                stemina += dia * 25;
                stemina += iron * 5; 
                stemina += stone * 1; 
                picks[2]--;
            }
        }
        
        return stemina;
    }
}