import java.util.*;
class Solution {
    class Songs implements Comparable<Songs> {
        int idx;
        int play;
        
        public Songs(int idx, int play){
            this.idx = idx;
            this.play = play;
        }
        
        @Override
        public String toString(){
            return "idx: " + idx + ", play: " + play + "\n";
        }
        
        @Override
        public int compareTo(Songs other){
            if(other.play == this.play){
                return this.idx - other.idx;
            }
            return other.play - this.play;
        }
        
    }
    
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,Integer> genreMap = new HashMap<>(); // 장르,플레이
        HashMap<String, List<Songs>> songsMap = new HashMap<>();  // 장르: [고유번호, 플레이]
        
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genreMap.put(genre, genreMap.getOrDefault(genre,0) + play);
            
            Songs song = new Songs(i, play);
            if(songsMap.containsKey(genre)){
                songsMap.get(genre).add(song);
            } else{
                List<Songs> list = new ArrayList<>();
                list.add(song);
                songsMap.put(genre, list);                
            }
        }
        
        List<String> sortedGenre = new ArrayList<>(genreMap.keySet());
        
        Collections.sort(sortedGenre, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return genreMap.get(s2) - genreMap.get(s1);
            }
        });
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(String genre : sortedGenre){
            List<Songs> songs = songsMap.get(genre);
            Collections.sort(songs);
            int cnt = 1;    // 한 장르당 2개씩만
            for(Songs song : songs){
                if(cnt > 2) break;
                answer.add(song.idx);   // 고유 번호 등록
                cnt ++;
            }
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}