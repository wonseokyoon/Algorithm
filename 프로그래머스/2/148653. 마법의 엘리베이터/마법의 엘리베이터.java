class Solution {
public int solution(int storey) {
        String str = String.valueOf(storey);
        int len = str.length();
        int cnt = 0;

        int[] storeys = new int[str.length()];
        for (int i = 0; i < len; i++) {
            storeys[i] = str.charAt(i) - '0';
        }


        for (int i = len - 1; i > 0; i--) {
            int num = storeys[i];

            if (num < 5) {            // 내림
                cnt += num;
            } else if (num > 5) {   // 올림
                if(num == 10){
                    storeys[i-1]++;
                    continue;
                }
                cnt += 10 - num;
                storeys[i - 1]++;     // 올림 처리
            } else {
                if (storeys[i - 1] >= 5) {      // 다음 자릿수가 5 이상이면 올림
                    storeys[i - 1]++;     // 올림 처리
                }
                // 4이하면 내림 처리
                cnt += 5;
            }
        }

        int num = storeys[0];   // 맨 앞자리
        if (num <= 5) {            // 내림
            cnt += num;
        } else {   // 올림
            if(num == 10){
                cnt ++ ;
            }else{
                cnt += 10 - num + 1;
            }
        }

        return cnt;
    }
}