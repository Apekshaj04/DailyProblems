class Solution {
    public long recursiveCall(int[][] questions,int index,int n,long[]dp ){
        if(index>=n){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        long take = questions[index][0] + recursiveCall(questions, index + 1 + questions[index][1], n, dp);
        long skip = recursiveCall(questions, index + 1, n, dp);
        return dp[index] = Math.max(take,skip);
    }
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        Arrays.fill(dp,-1);
        return recursiveCall(questions,0,n,dp);
    }
}