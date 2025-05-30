class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] clist = new boolean[n];
        boolean[] visited = new boolean[n];
        return dfs(0,-1,visited,hasApple,clist,adj);
    }
    public int dfs(int node,int parent,boolean[] visited, List<Boolean> hasApple,boolean[] clist,ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        int total = 0 ;
        for(int ne:adj.get(node)){
            if(!visited[ne]){
                int subtotal = dfs(ne,node,visited,hasApple,clist,adj);
                if(subtotal>0 || hasApple.get(ne)){
                    total = total + subtotal+2;
                    clist[node] = true;
                }
            }

        }
        if(clist[node] || hasApple.get(node)){
            return total;
        }
        return 0 ;
    }
}