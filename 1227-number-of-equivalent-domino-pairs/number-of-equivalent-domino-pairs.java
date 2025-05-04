class Solution {
    public int numEquivDominoPairs(int[][] d) {
        int n = d.length;
        int cnt = 0;
        for(int i = 0;i<n;i++){
            int[] x= d[i];
            for(int j= i+1;j<n;j++){
                if((x[0]==d[j][0] && x[1]==d[j][1]) || (x[0]==d[j][1] && x[1]==d[j][0])){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}