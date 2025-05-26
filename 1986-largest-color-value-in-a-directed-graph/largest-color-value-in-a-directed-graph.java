class Solution {
    public boolean hasCycle(List<List<Integer>> adj, int n) {
        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (cycleUtil(i, visited, recStack, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cycleUtil(int node, boolean[] visited, boolean[] recStack, List<List<Integer>> adj) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (cycleUtil(neighbor, visited, recStack, adj)) return true;
            } else if (recStack[neighbor]) {
                return true;
            }
        }

        recStack[node] = false;
        return false;
    }

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        if (hasCycle(adj, n)) return -1;

        int[][] dp = new int[n][26]; 
        boolean[] visited = new boolean[n];
        int maxi = 0;

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, dfs(i, adj, dp, visited, colors));
        }

        return maxi;
    }

    public int dfs(int node, List<List<Integer>> adj, int[][] dp, boolean[] visited, String colors) {
        if (visited[node]) return 0;
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            dfs(neighbor, adj, dp, visited, colors);
            for (int c = 0; c < 26; c++) {
                dp[node][c] = Math.max(dp[node][c], dp[neighbor][c]);
            }
        }

        dp[node][colors.charAt(node) - 'a']++;
        return Arrays.stream(dp[node]).max().getAsInt();
    }
}
