class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides,(a,b)->Integer.compare(a[1],b[1]));
        long[] dp = new long[n+1];
        int rideIndex = 0; 
        int m = rides.length;
        for(int i = 1;i<=n;i++){
            dp[i] = Math.max(dp[i],dp[i-1]);
            while(rideIndex<rides.length && rides[rideIndex][1]==i){
                int start = rides[rideIndex][0];
                int end  = rides[rideIndex][1];
                int tip = rides[rideIndex][2];
                int total = end - start + tip;
                dp[end] = Math.max(dp[end],dp[start]+total);
                rideIndex++;
            }
        }
        return dp[n];
    }
}