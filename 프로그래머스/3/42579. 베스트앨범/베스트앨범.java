import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int length = genres.length;
        // 장르의 재생 횟수
        HashMap<String,Integer> genreMap = new HashMap<>();
        // 노래별 수록번호, 재생 횟수
        HashMap<String,List<int[]>> songsMap = new HashMap<>();
        
        for(int i = 0; i< length; i++){
            String genre = genres[i];
            int cnt = plays[i];
            
            genreMap.put(genre, genreMap.getOrDefault(genre,0) + cnt);
            
            int[] info = {i,cnt};
            // 기존에 이미 등록된 장르
            if(songsMap.containsKey(genre)){
                songsMap.get(genre).add(info);
            } else{
                List<int[]> newSongList = new ArrayList<>();
                newSongList.add(info);
                songsMap.put(genre,newSongList);
            }
        }
        
        // 정렬(장르 재생 횟수 기준 내림차순)
        List<String> sortedGenres = new ArrayList<>(genreMap.keySet());
        Collections.sort(sortedGenres, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return genreMap.get(s2) - genreMap.get(s1);
            }
        });
        
        List<Integer> best = new ArrayList<>();
        for(String genre: sortedGenres){
            List<int[]> values = songsMap.get(genre);
            
            Collections.sort(values, new Comparator<int[]>(){
                @Override
                public int compare(int[] s1, int[] s2){
                    if(s1[1] == s2[1]){     // 재생 횟수가 같다면 고유 번호 기준 오름차순
                        return s1[1] - s2[1];
                    }
                    
                    return s2[1] - s1[1];
                }
            });
            
            int cnt = 0;
            for(int[] value : values){
                if(cnt > 1) break;
                int number = value[0];  // 고유 번호
                best.add(number);
                cnt ++;
            }
        }
        
//         System.out.print("베스트 앨범: " + best);
        
        
//         for(String key: songsMap.keySet()){
//             System.out.print("key: " + key+", value:");
//             List<int[]> values = songsMap.get(key);
//             for(int[] value: values){
//                 System.out.print(" " + Arrays.toString(value));
//             }
//             System.out.println("");
//         }
        
        
        return best.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}