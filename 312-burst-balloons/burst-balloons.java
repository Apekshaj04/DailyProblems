class Solution {
    public int solve(int[] newNums, int left, int right, int[][] dp) {
        if (left + 1 == right) {
            return 0; 
        }
        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int max = 0;
        for (int k = left + 1; k < right; k++) {
            int coins = newNums[left] * newNums[k] * newNums[right];
            int total = solve(newNums, left, k, dp) + solve(newNums, k, right, dp) + coins;
            max = Math.max(max, total);
        }

        return dp[left][right] = max;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(newNums, 0, n + 1, dp); 
    }
}
