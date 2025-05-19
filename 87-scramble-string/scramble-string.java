class Solution {
    public boolean solve(String s1, String s2, int i1, int i2, int length, Boolean[][][] dp) {
        if (dp[i1][i2][length] != null) return dp[i1][i2][length];

        String substr1 = s1.substring(i1, i1 + length);
        String substr2 = s2.substring(i2, i2 + length);

        // Base case: if substrings are equal
        if (substr1.equals(substr2)) {
            return dp[i1][i2][length] = true;
        }

        // Early pruning: if character counts don't match
        int[] freq = new int[26];
        for (int i = 0; i < length; i++) {
            freq[s1.charAt(i1 + i) - 'a']++;
            freq[s2.charAt(i2 + i) - 'a']--;
        }
        for (int count : freq) {
            if (count != 0) return dp[i1][i2][length] = false;
        }

        // Try all possible splits
        for (int k = 1; k < length; k++) {

            if (
                solve(s1, s2, i1, i2, k, dp) &&
                solve(s1, s2, i1 + k, i2 + k, length - k, dp)
            ) {
                return dp[i1][i2][length] = true;
            }
            if (
                solve(s1, s2, i1, i2 + length - k, k, dp) &&
                solve(s1, s2, i1 + k, i2, length - k, dp)
            ) {
                return dp[i1][i2][length] = true;
            }
        }

        return dp[i1][i2][length] = false;
    }

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) return false;
        Boolean[][][] dp = new Boolean[n][n][n + 1];
        return solve(s1, s2, 0, 0, n, dp);
    }
}
