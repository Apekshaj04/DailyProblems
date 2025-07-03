class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
       Set<Integer> restrict = new HashSet<>();
for (int val : restricted) {
    restrict.add(val);
}

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> q =  new LinkedList<>();
        if(restrict.contains(0)){
            return 0;
        }
        q.offer(0);
        boolean[] visited = new boolean[n];
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int node = q.poll();
                visited[node] = true;
                for(int nei:adj.get(node)){
                    if(!restrict.contains(nei) && !visited[nei]){
                        q.offer(nei);
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            if(visited[i]){
                count++;
            }
        }
        return count;

    }
}