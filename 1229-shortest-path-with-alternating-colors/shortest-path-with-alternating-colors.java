class Solution {
    static class Pair{
        int node;
        String color ;
        Pair(int node,String c){
            this.node = node;
            this.color = c;
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
          ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : redEdges) {
            adj.get(edge[0]).add(new Pair(edge[1], "R"));
        }

        for (int[] edge : blueEdges) {
            adj.get(edge[0]).add(new Pair(edge[1], "B"));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, null)); 

        Set<String> visited = new HashSet<>();
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair current = q.poll();
                int node = current.node;
                String prevColor = current.color;

                dist[node] = Math.min(dist[node], steps);

                for (Pair neighbor : adj.get(node)) {
                    String edgeColor = neighbor.color;
                    String state = neighbor.node + "_" + edgeColor;

                    if (!edgeColor.equals(prevColor) && !visited.contains(state)) {
                        visited.add(state);
                        q.offer(new Pair(neighbor.node, edgeColor));
                    }
                }
            }
            steps++;
        }
        for(int i = 0;i<n;i++){
            dist[i] = (dist[i]==Integer.MAX_VALUE)?-1:dist[i];
        }
return dist;
    }
}