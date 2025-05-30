class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0}); // {time, node}

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int time = p[0];
            int node = p[1];

            // Already found a better path before
            if (time > dist[node]) continue;

            // Disappeared before we got here
            if (time >= disappear[node]) continue;

            for (int[] ne : adj.get(node)) {
                int nei = ne[0];
                int cost = ne[1];
                int newTime = time + cost;

                if (newTime < disappear[nei] && newTime < dist[nei]) {
                    dist[nei] = newTime;
                    pq.offer(new int[]{newTime, nei});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }
}
