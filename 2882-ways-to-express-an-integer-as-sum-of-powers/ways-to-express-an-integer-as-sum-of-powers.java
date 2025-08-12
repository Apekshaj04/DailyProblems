class Solution {
    static int MOD = 1_000_000_007;
    static int expo ;

    private long binary(int base, int e) {
        long ans = 1, b = base;
        while (e > 0) {
            if ((e & 1) == 1) ans *= b;
            b *= b;
            e >>= 1;
        }
        return ans;
    }

    public int function(int start,int n,int sum,int[][] dp){
        if(sum>n) return 0;
        if(sum==n) return 1;
        if(start>n) return 0;
        if(dp[start][sum]!=-1) return dp[start][sum];
        long bin = binary(start,expo);
        if(bin>n) return 0;
        int take =0,notTake = 0 ;        
        take = (take+function(start+1,n,(int)(sum+bin),dp))%MOD;
        notTake = (notTake+function(start+1,n,sum,dp)%MOD);
        return dp[start][sum] = ((take%MOD)+(notTake%MOD))%MOD;  
    }
    public int numberOfWays(int n, int x) {

        expo = x;
        int[][] dp = new int[n+1][n+1];
        for(int i = 0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        int result = function(1,n,0,dp);
        return result;

    }
}