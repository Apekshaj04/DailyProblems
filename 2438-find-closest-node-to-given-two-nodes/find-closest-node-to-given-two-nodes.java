class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            if(edges[i]==-1) continue;
            adj.get(i).add(edges[i]);
        }
        boolean[] visited = new boolean[n];
        int[] dist1 =  new int[n];
        Arrays.fill(dist1,-1);
        dfs(node1,adj,visited,0,dist1);
        visited = new boolean[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist2,-1);
        dfs(node2,adj,visited,0,dist2);
        int minNode = -1;
        int minDist = Integer.MAX_VALUE;
        for(int i = 0 ;i<n;i++){
            if(dist1[i]!=-1 && dist2[i]!=-1){

            int dist = Math.max(dist1[i],dist2[i]);
            if(minDist>dist){
                minDist = dist;
                minNode = i;
            }
            }
        }
        return minNode;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited,int depth,int[] dist){
        if(visited[node]) return ;
        visited[node] = true;
        dist[node] = depth;
        for(int ne:adj.get(node)){
            if(!visited[ne]){
                dfs(ne,adj,visited,depth+1,dist);
            }
        }
    }
}