class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length, m = grid[0].length, servers = 0;
        int[] rowCount = new int[n], colCount = new int[m];

        // Count servers in each row and column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                    servers++;
                }
            }
        }

        // Subtract isolated servers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
                    servers--;
                }
            }
        }

        return servers;
    }
}
