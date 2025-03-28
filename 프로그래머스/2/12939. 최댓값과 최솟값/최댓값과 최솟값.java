class Solution {
    public String solution(String s) {
        String[] params = s.split(" ");
        int maxRes = Integer.parseInt(params[0]);
        int minRes = Integer.parseInt(params[0]);

        for(String param : params) {
            int num = Integer.parseInt(param);
            if(num > maxRes) {
                maxRes = num;
            } else if (num < minRes) {
                minRes = num;
            }
        }
        return minRes + " " + maxRes;
    }
}