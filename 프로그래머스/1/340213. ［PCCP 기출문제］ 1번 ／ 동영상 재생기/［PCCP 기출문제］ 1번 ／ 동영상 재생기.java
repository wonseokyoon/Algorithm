class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int min= Integer.parseInt(pos.split(":")[0]);   // 분
        int sec= Integer.parseInt(pos.split(":")[1]);   // 초
        int op_min= Integer.parseInt(op_start.split(":")[0]);    // 오프닝 분
        int op_sec= Integer.parseInt(op_start.split(":")[1]);    // 오프닝 초
        int end_min= Integer.parseInt(op_end.split(":")[0]);        // 엔딩 분
        int end_sec= Integer.parseInt(op_end.split(":")[1]);          // 엔딩 초
        int max_min= Integer.parseInt(video_len.split(":")[0]);         // 총 길이 분
        int max_sec= Integer.parseInt(video_len.split(":")[1]);             // 총 길이 초

        for(String command: commands){
            // 오프닝 구간에 위치하는지 확인
            if(opCheck(min,sec,op_min,op_sec,end_min,end_sec)){
                // 오프닝 종료 시점으로 이동
                min=end_min;
                sec=end_sec;
            }

            switch(command) {
                case "next":
                    sec += 10;
                    if (sec >= 60) {
                        sec -= 60;
                        min++;
                    }
                    break;
                case "prev":
                    sec -= 10;
                    if (sec < 0) {
                        min--;
                        if(rangeCheck2(min,sec)){
                            min=0;
                            sec=0;
                        }
                        else {
                            sec += 60;
                        }
                    }
                    break;

            }

            // 최대길이보다 길어지면
            if(rangeCheck1(min,sec,max_min,max_sec)){
                min=max_min;
                sec=max_sec;
            }
        }
        if(opCheck(min,sec,op_min,op_sec,end_min,end_sec)){
            // 오프닝 종료 시점으로 이동
            min=end_min;
            sec=end_sec;
        }

        String format=String.format("%02d:%02d",min,sec);
        return format;
    }

    // 최대 길이보다 긴지
    private boolean rangeCheck1(int min, int sec, int maxMin, int maxSec) {
        if(min>=maxMin && sec>maxSec) return true;
        return false;
    }

    // 0분 0초보다 짧은지
    private boolean rangeCheck2(int min, int sec) {
        if(min<0) return true;

        return false;
    }

    // 오프닝 범위에 있는지
    private boolean opCheck(int min, int sec, int opMin, int opSec, int endMin, int endSec) {
        if(opMin==endMin && min==opMin){
            if(sec>=opSec && sec<=endSec){
                return true;
            }
        }else {
            if(min>opMin && min<endMin) return true;
            if(min==opMin){
                if(sec>=opSec) return true;
            }
            if(min==endMin){
                if(sec<=endSec) return true;
            }
        }
        return false;
    }
}