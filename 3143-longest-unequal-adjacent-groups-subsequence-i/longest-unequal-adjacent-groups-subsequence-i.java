class Solution {
    public List<String> helper(String[] words,int[] groups,int i,int prevGroup,int n ,List<String>[][]dp){
        if(i==n) return new ArrayList<>();
        if(dp[i][prevGroup+1]!=null) return dp[i][prevGroup+1];
        List<String> skip = helper(words,groups,i+1,prevGroup,n,dp);
        List<String> take  =new ArrayList<>();
        if(groups[i]!=prevGroup){
            take.add(words[i]);
            take.addAll(helper(words,groups,i+1,groups[i],n,dp));
        }
        dp[i][prevGroup+1] = (skip.size()>take.size())?skip:take;
        return dp[i][prevGroup+1];
    }
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String>[][] dp = new ArrayList[n+1][3];
        return helper(words,groups,0,-1,n,dp);
    }
}