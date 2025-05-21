import java.util.Arrays;

class Solution {
    public int countDigitOne(int n) {
        int[][][] dp = new int[12][2][12];
        
        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }

        String s = String.valueOf(n);
        return solve(s, 0, 1, 0, dp);
    }
    public int solve(String s, int index, int tight, int count, int[][][] dp) {

        if (index == s.length()) {
            return count;
        }

        if (dp[index][tight][count] != -1) {
            return dp[index][tight][count];
        }

        int ans = 0;

        int limit = (tight == 1 ? s.charAt(index) - '0' : 9);

        for (int i = 0; i <= limit; i++) {
            int newCount = count + (i == 1 ? 1 : 0);
            int newTight = (tight == 1 && i == s.charAt(index) - '0') ? 1 : 0;
            ans += solve(s, index + 1, newTight, newCount, dp);
        }
        return dp[index][tight][count] = ans;
    }
}
