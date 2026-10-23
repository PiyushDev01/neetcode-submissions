class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in= new int[n+1]; //n+1 bcos index starts from 1
        int[] out= new int[n+1];
        for(int[] e: trust){
            int a= e[0];
            int b= e[1];
            in[b]++;
            out[a]++;
        }
        int res=-1;
        for(int i=1; i<=n; i++){
            if(in[i]==n-1 && out[i]==0) res= Math.max(i,res);
        }
        return res;
    }

}