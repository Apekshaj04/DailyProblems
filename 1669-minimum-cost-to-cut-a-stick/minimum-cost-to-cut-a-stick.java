class Solution {
    public int solve(int[] cuts,int i ,int j,int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k = i;k<=j;k++){
            int temp = solve(cuts,i,k-1,dp) + solve(cuts,k+1,j,dp) + (cuts[j+1]-cuts[i-1]);
            min = Math.min(min,temp);
        }
        return  dp[i][j]  = min ;

    }
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] ocuts = new int[m+2];
        ocuts[0] = 0;
        ocuts[m+1] = n;
        for(int i = 0;i<m;i++){
            ocuts[i+1] = cuts[i];
        }
        Arrays.sort(ocuts);
        int[][] dp =new int[m+2][m+2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(ocuts,1,m,dp);
    }
}