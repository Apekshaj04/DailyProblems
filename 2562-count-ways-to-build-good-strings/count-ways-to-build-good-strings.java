class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = 1_000_000_007;
        int[] dp = new int[high + 1];
        dp[0] = 1; 

        for (int i = 1; i <= high; i++) {
            if (i - zero >= 0) {
                dp[i] = (dp[i] + dp[i - zero]) % MOD;
            }
            if (i - one >= 0) {
                dp[i] = (dp[i] + dp[i - one]) % MOD;
            }
        }

        int total = 0;
        for (int i = low; i <= high; i++) {
            total = (total + dp[i]) % MOD;
        }

        return total;
    }
}
