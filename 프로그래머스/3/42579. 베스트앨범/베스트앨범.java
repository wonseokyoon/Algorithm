import java.util.*;

class Solution {
    public class Music implements Comparable<Music> {
        private int idx;
        private int play;
        
        public Music(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
        
        @Override
        public int compareTo(Music other) {
            if(this.play == other.play) {
                return this.idx - other.idx;
            }
            return other.play - this.play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String,Integer> genreMap = new HashMap<>();       // 장르 : 재생횟수
        HashMap<String,ArrayList<Music>> musicMap = new HashMap<>();         // 장르 : [고유 번호, 재생횟수]             
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            musicMap.put(genre,new ArrayList<>());
        }
        
        for(int i = 0; i < genres.length; i ++) {
            String genre = genres[i];
            int play = plays[i];
            
            genreMap.put(genre,genreMap.getOrDefault(genre,0) + play);
            
            Music music = new Music(i,play);
            musicMap.get(genre).add(music);
        }
        
        ArrayList<String> sortedGenre = new ArrayList<>();
        for(String key : genreMap.keySet()) {
            sortedGenre.add(key);
        }
        
        Collections.sort(sortedGenre, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                int play1 = genreMap.get(s1);
                int play2 = genreMap.get(s2);
                
                return play2 - play1;
            }
        });
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(String genre : sortedGenre) {
            int cnt = 1;
            ArrayList<Music> musics = musicMap.get(genre);
            Collections.sort(musics);   // 정렬
            
            for(Music music : musics) {
                if(cnt > 2) break;
                answer.add(music.idx);
                cnt ++;
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}