class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        Set<String> pacificReachable = new HashSet<>();
        Set<String> atlanticReachable = new HashSet<>();

        // Directions for movement
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // BFS from all Pacific border cells
        for (int i = 0; i < n; i++) {
            bfs(i, 0, heights, pacificReachable, dirs);
            bfs(i, m - 1, heights, atlanticReachable, dirs);
        }
        for (int j = 0; j < m; j++) {
            bfs(0, j, heights, pacificReachable, dirs);
            bfs(n - 1, j, heights, atlanticReachable, dirs);
        }

        // Result: intersection of both reachables
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String key = i + "," + j;
                if (pacificReachable.contains(key) && atlanticReachable.contains(key)) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void bfs(int i, int j, int[][] heights, Set<String> reachable, int[][] dirs) {
        int n = heights.length;
        int m = heights[0].length;
        Queue<int[]> queue = new LinkedList<>();
        String startKey = i + "," + j;
        queue.offer(new int[]{i, j});
        reachable.add(startKey);

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                String newKey = nx + "," + ny;
                if (nx >= 0 && ny >= 0 && nx < n && ny < m &&
                    !reachable.contains(newKey) &&
                    heights[nx][ny] >= heights[x][y]) {
                    queue.offer(new int[]{nx, ny});
                    reachable.add(newKey);
                }
            }
        }
    }
}
