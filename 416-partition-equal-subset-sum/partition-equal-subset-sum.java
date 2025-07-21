class Solution {
    public boolean solve(int[] nums,int sum,int n,int[][] dp){
        if(sum==0) return true;
        if(n==0) return false;
        if(dp[n][sum]!=-1) return dp[n][sum]==1;

        boolean ans;
        if(nums[n-1]<=sum){
            ans = solve(nums,sum-nums[n-1],n-1,dp) || solve(nums,sum,n-1,dp);
        }
        else{
            ans= solve(nums,sum,n-1,dp);
        }
        dp[n][sum] = ans?1:0;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        int n = nums.length;
        int[][] dp = new int[n+1][sum+1];
        for(int i = 0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(nums,sum/2,n,dp);
    }
}