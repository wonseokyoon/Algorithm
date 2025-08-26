import java.util.*;
import java.time.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        // #을 치환
        m = replaceShap(m);
        
        int maxTime = 0;
        String answer = "(None)";
        
        for(String musicinfo: musicinfos){
            String[] params = musicinfo.split(",");
            String title = params[2];
            String info = replaceShap(params[3]);
            
            LocalTime start = LocalTime.parse(params[0]);
            LocalTime end = LocalTime.parse(params[1]);
            // 시간차
            int time = (int) Duration.between(start,end).toMinutes();
            
            StringBuilder sb = new StringBuilder();
            char[] ch = info.toCharArray();
            int length = info.length();
            for(int i=0;i<time;i++){
                sb.append(ch[i%length]);
            }
            
            // 유사성 체크
            if(checkCommon(m,sb.toString())){
                
                // 새로운게 더 길면 -> 덮어씌움
                if(time > maxTime){
                    maxTime = time;
                    answer = title;
                }
            }
        }
        
        // 제목 반환
        return answer;
    }
    
    // 유사성 체크
    boolean checkCommon(String m,String info){
        // 멜로디가 info에 포함되는지
        if(info.contains(m)) return true;
        return false;
    }
    
    String replaceShap(String info){
        return info.replaceAll("C#","H")
            .replaceAll("D#","I")
            .replaceAll("F#","J")
            .replaceAll("G#","K")
            .replaceAll("A#","L")
            .replaceAll("B#","M");
    }
}