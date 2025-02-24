class Solution {
    public long fuel = 0;
    public int dfs(int node,int parent ,List<List<Integer>> adj,int seats){
        int representative =1 ;
        for(int neighbor:adj.get(node)){
            if(neighbor==parent){
                continue;
            }
            int people = dfs(neighbor,node,adj,seats);
            fuel += Math.ceil((double) people/seats);
            representative += people;
        }
        return representative;
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        int n =roads.length+1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:roads){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        dfs(0,-1,adj,seats);
        return fuel;
    }
}