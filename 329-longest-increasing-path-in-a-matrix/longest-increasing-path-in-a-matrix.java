class Solution {
    public boolean isSafe(int i, int j, int m, int n) {
        return (i >= 0 && i < m) && (j >= 0 && j < n);
    }

    public int recursive(int i, int j, int[][] matrix, int m, int n, int prev, int[][] dp) {
        if (!isSafe(i, j, m, n)) {
            return 0;
        }

        if (matrix[i][j] <= prev) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int left = 1 + recursive(i, j - 1, matrix, m, n, matrix[i][j], dp);
        int right = 1 + recursive(i, j + 1, matrix, m, n, matrix[i][j], dp);
        int up = 1 + recursive(i - 1, j, matrix, m, n, matrix[i][j], dp);
        int down = 1 + recursive(i + 1, j, matrix, m, n, matrix[i][j], dp);

        return dp[i][j] = Math.max(left, Math.max(right, Math.max(up, down)));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, recursive(i, j, matrix, m, n, -1, dp));
            }
        }

        return ans;
    }
}
