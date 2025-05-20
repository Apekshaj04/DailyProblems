class Solution {
    public int solve(int i ,int k,int[] arr,int[] dp){
        if(i==arr.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int maxCost = 0;
        int max = 0;
        for(int j=i;j<Math.min(k+i,arr.length);j++){
             max = Math.max(max,arr[j]);
             int length = j-i+1;
             int cost = length*max + solve(j+1,k,arr,dp);
             maxCost = Math.max(maxCost,cost);
        }
        return dp[i] = maxCost;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
     int n = arr.length ;
     int[] dp = new int[n];
     Arrays.fill(dp,-1);
     return solve(0,k,arr,dp);
    }

}