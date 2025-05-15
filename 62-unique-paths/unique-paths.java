class Solution {
    public boolean isSafe(int i , int j,int n,int m ){
        return (i>=0 && i<m) && (j>=0 && j<n);
    }
    public int recursive(int i , int j ,int[][] dp ,int m,int n){
        if(i==m-1 && j==n-1){

            return 1;
        }
        
        if(!isSafe(i,j,n,m)){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down = recursive(i+1,j,dp,m,n);
        int up = recursive(i,j+1,dp,m,n);
        return dp[i][j] = up+down;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return recursive(0,0,dp,m,n);
    }
}