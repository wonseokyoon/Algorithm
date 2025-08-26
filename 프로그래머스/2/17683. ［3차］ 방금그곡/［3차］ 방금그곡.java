import java.util.*;
import java.time.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        // # 처리
        m = replaceShap(m);
        int maxTime = 0;
        String answer = "(None)";
        
        for(String musicinfo:musicinfos){
            String[] params = musicinfo.split(",");
            LocalTime startTime = LocalTime.parse(params[0]);
            LocalTime endTime = LocalTime.parse(params[1]);
            int playTime = (int) Duration.between(startTime,endTime).toMinutes();
            
            String title = params[2];
            String info = replaceShap(params[3]);
            StringBuilder fullMelody = new StringBuilder();
            int length = info.length();
            // 재생 시간동안 나온 전체 악보
            for(int i = 0; i < playTime; i++){
                fullMelody.append(info.charAt(i % length));
            }
            System.out.println("풀멜로디: " + fullMelody);
            
            // 전체 악보에 기억중인 멜로디가 포함되어있다면
            if(fullMelody.toString().contains(m)){
                if(playTime > maxTime){
                    answer = title;
                    maxTime = playTime;
                }
            }
        }
        return answer;
    }
    
    String replaceShap(String str){
        return str
            .replaceAll("A#","H")
            .replaceAll("B#","I")
            .replaceAll("C#","J")
            .replaceAll("D#","K")
            .replaceAll("E#","L")
            .replaceAll("F#","M")
            .replaceAll("G#","N");
    }
}