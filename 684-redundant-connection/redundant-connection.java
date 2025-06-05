class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        for(int i = 1;i<=n;i++){
            parent[i] = i ;
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int pu = findParent(u,parent);
            int pv = findParent(v,parent);
            if(pu==pv){
                return edge;
            }
            if(pu<pv){
                parent[pv] = pu ;
            }
            else{
                parent[pu] = pv;
            }
        }
        return new int[2];
    }
    int findParent(int c,int[] parent){
        if(parent[c]==c) return c;
        return parent[c] = findParent(parent[c],parent);
    }
}