class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int cnt = 0;

        int[][] dir = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, visited, dir, i, j);
                }
            }
        }
        return cnt;
    }

    public boolean isSafe(char[][] grid, int newX, int newY, boolean[][] visited) {
        int i = grid.length;
        int j = grid[0].length;
        return newX >= 0 && newX < i && newY >= 0 && newY < j &&
               !visited[newX][newY] && grid[newX][newY] == '1';
    }

    public void dfs(char[][] grid, boolean[][] visited, int[][] dir, int i, int j) {
        visited[i][j] = true;
        for (int[] d : dir) {
            int newX = i + d[0];
            int newY = j + d[1];
            if (isSafe(grid, newX, newY, visited)) {
                dfs(grid, visited, dir, newX, newY);
            }
        }
    }
}
