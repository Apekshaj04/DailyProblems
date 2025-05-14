class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean[]dp = new Boolean[n];
        Set<String> set = new HashSet<>(wordDict);
        return recursive(s,set,dp,0);

    }
    boolean recursive(String s,Set<String> set,Boolean[] dp,int start){
        if(start==s.length()) return true ;
        if(dp[start]!=null) return dp[start];
        for(int i = start+1;i<=s.length();i++){
            String word = s.substring(start,i);
            if(set.contains(word) && recursive(s,set,dp,i)){
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }
}