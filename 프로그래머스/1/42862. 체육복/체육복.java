class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] list=new int[n];
        for(int i=0;i<n;i++){
            list[i]=1;
        }
        // 1 0 1 0 1
        for(int i:lost){
            list[i-1]-=1;
        }
        // 2 0 2 0 2
        for(int i:reserve){
            list[i-1]+=1;
        }

        for(int i=0;i<n;i++) {
            if(list[i]==2){
                if(i-1>=0 && list[i-1]==0){
                    list[i-1]+=1;
                }else if(i+1<n && list[i+1]==0){
                    list[i+1]+=1;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(list[i]>=1) cnt++;
        }


        return cnt;

    }
}