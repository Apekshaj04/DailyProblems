class Solution {
    public boolean canWin(Boolean[] dp,int n ){
        if(dp[n]!=null){
            return dp[n];
        }
        for(int i = 1;i<n;i++){
            if(n%i==0){
                if(!canWin(dp,n-i)){
                    return dp[n] = true;
                }
            }
        }
        dp[n] = false;
        return dp[n];
    }
    public boolean divisorGame(int n) {
        Boolean[] dp = new Boolean[n+1];
        return canWin(dp,n);
    }
}