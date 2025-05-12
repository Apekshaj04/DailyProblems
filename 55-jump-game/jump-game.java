class Solution {
    public boolean canJump(int[] nums) {
        int n  = nums.length;
        if(n==1){
            return true;
        }
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        dp[0] = nums[0];
        for(int i = 1;i<n;i++){
            if(dp[i-1]<i){
                return false;
            }
            dp[i] = Math.max(dp[i-1],i+nums[i]);
        }
        return dp[n-1]>=n-1;
    }
}