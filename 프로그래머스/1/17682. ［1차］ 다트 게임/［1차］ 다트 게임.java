import java.util.Arrays;
class Solution {
    public int solution(String dartResult) {
        int idx = 0;
        int[] arr = new int[3];
        String str="";
        for (int i = 0; i < dartResult.length(); i++) {
            switch (dartResult.charAt(i)) {
                case 'S':
                    arr[idx] = (int) Math.pow(Integer.parseInt(str), 1);
                    idx++;
                    str="";
                    break;
                case 'D':
                    arr[idx] = (int) Math.pow(Integer.parseInt(str), 2);
                    idx++;
                    str="";
                    break;
                case 'T':
                    arr[idx] = (int) Math.pow(Integer.parseInt(str), 3);
                    idx++;
                    str="";
                    break;
                case '*':
                    if (idx-1 == 0) {
                        arr[idx-1] *= 2;
                    } else {
                        arr[idx - 2] *= 2;
                        arr[idx-1] *= 2;
                    }
                    break;
                case '#':
                    arr[idx-1] *= -1;
                    break;
                default:
                    str+=dartResult.charAt(i);
            }
        }
        return Arrays.stream(arr).sum();
    }
}