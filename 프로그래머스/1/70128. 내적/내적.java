class Solution {
     public int solution(int[] a, int[] b) {
        int total = 0;

        for (int i = 0; i < a.length; i++) {
            int multiple = a[i] * b[i];
            total += multiple;
        }
        System.out.println(total);
        return total;
    }
}