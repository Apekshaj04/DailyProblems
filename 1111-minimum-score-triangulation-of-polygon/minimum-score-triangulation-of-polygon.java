class Solution {
    public int solve(int i,int j,int[] values,int[][] dp){
        if(i>=j){
            return 0 ;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            int temp = solve(i,k,values,dp) + solve(k+1,j,values,dp) + values[i-1]*values[k]*values[j];
            min = Math.min(min,temp);
        }
        return dp[i][j] = min ;
    }
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for(int[] rows:dp ){
            Arrays.fill(rows,-1);
        }
        return solve(1,n-1,values,dp);
    }
}