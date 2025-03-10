class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] filter = {"aya", "ye", "woo", "ma"};
        for(int i = 0; i < babbling.length;i++){
            for(int j = 0; j < filter.length; j++){
                if(!babbling[i].contains("ayaaya") && !babbling[i].contains("yeye") &&!babbling[i].contains("woowoo")&&!babbling[i].contains("mama"))
                babbling[i] = babbling[i].replace(filter[j]," ");   
            }
            babbling[i] = babbling[i].replace(" ", "");
            if(babbling[i] == "")   answer ++;
        }
        return answer;
    }
}