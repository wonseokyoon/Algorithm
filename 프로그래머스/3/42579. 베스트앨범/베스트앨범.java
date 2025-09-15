import java.util.*;

class Solution {
    public class Song implements Comparable<Song> {
        int play;   // 재생횟수 
        int idx;    // 고유 번호
        
        public Song(int play, int idx){
            this.play = play;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Song other){
            if(other.play == this.play) return this.idx - other.idx;
            else return other.play - this.play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 재생 횟수
        Map<String,Integer> genreMap = new HashMap<>();
        Map<String,ArrayList<Song>> songMap = new HashMap<>(); // 장르: [재생횟수, 고유번호]
        
        for(int i = 0; i < genres.length; i ++) {
            String genre = genres[i];
            int play = plays[i];
            
            genreMap.put(genre, genreMap.getOrDefault(genre,0) + play);
            
            Song song = new Song(play,i);
            if(songMap.containsKey(genre)){
                songMap.get(genre).add(song);
            } else{
                ArrayList<Song> songs = new ArrayList<>();
                songs.add(song);
                songMap.put(genre,songs);
            }
        }
        
        ArrayList<String> sortedList = new ArrayList<>();
        for(String key : genreMap.keySet()){
            sortedList.add(key);
        }
        
        // 내림차순 정렬
        Collections.sort(sortedList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                return genreMap.get(s2) - genreMap.get(s1);
            }
        });
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(String genre : sortedList){
            ArrayList<Song> songList = songMap.get(genre);
            Collections.sort(songList);
            int k = 1;
            
            for(Song song : songList){
                if(k > 2) break;
                answer.add(song.idx);
                k++;
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}