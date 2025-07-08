class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a,b)->Integer.compare(a[1],b[1]));
        int n  = events.length;
        int[][] dp  = new int[n+1][k+1];
        for(int i = 1;i<=n;i++){
            int[] curr = events[i-1];
            int start = curr[0],end= curr[1],val=curr[2];
            int l = 0,r=i-1;
            while(l<r){
                int m = r-(r-l)/2;
                if(events[m][1]<start){
                    l = m;
                }
                else{
                    r = m-1;
                }
            }
            int prev = 0;
            if(events[l][1]<start){
                prev = l+1;
            }
            for(int j = 1;j<=k;j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[prev][j-1]+val);
            }
        }
        return dp[n][k];
        
    }
}