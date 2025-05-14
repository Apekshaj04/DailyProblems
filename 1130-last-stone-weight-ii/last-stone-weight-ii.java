class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) sum += stone;

        int[][] dp = new int[n][sum + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(0, 0, stones, sum, dp);
    }

    private int dfs(int i, int total, int[] stones, int sum, int[][] dp) {
        if (i == stones.length) {
            // ✅ Return absolute difference
            return Math.abs((sum - total) - total);
        }

        if (dp[i][total] != -1) return dp[i][total];

        // ✅ Choice: take the stone into the current subset or not
        int include = dfs(i + 1, total + stones[i], stones, sum, dp);
        int exclude = dfs(i + 1, total, stones, sum, dp);

        dp[i][total] = Math.min(include, exclude);
        return dp[i][total];
    }
}
