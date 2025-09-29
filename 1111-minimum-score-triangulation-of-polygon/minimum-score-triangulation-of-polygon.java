class Solution {
    public int function(int i,int j , int[][] dp,int[] values){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            int temp = function(i,k,dp,values)+function(k+1,j,dp,values)+values[i-1]*values[j]*values[k];
            min = Math.min(temp,min);
        }
        return dp[i][j] = min ; 
    }
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for(int i= 0 ;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return function(1,n-1,dp,values);
    }
}