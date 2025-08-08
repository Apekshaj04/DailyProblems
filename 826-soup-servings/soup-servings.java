class Solution {
    public double function(int i,int j,double[][] dp){
        if(i<=0 && j>0){
            return 1.0;
        }
        if(i<=0 && j<=0){
            return 0.5;
        }
        if(i>0 && j<=0){
            return 0.0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        double ans = (0.25)*(function(i-4,j,dp)+function(i-3,j-1,dp)+function(i-2,j-2,dp)+function(i-1,j-3,dp));
        return dp[i][j] = (double) ans;
    }
    public double soupServings(int n) {
        n = (n+24)/25;
        if(n>=500){
            return 1.0;
        }
        double[][] dp = new double[n+1][n+1];
        for(int i = 0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        double res = function(n,n,dp);
        return res;
    }
} 