class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        // cost,node,time
        int[] minTime = new int[n];
        Arrays.fill(minTime,Integer.MAX_VALUE);
        pq.offer(new int[]{passingFees[0],0,0});
        while(!pq.isEmpty()){
            int[] p = pq.poll();
            int cost = p[0];
            int node = p[1];
            int time = p[2];
            if(node==n-1) return cost;
            if(minTime[node]<=time) continue;
            minTime[node] = time;
            for(int[] nei:adj.get(node)){
                int v= nei[0];
                int x = nei[1];
                if(time+x<=maxTime){
                    pq.offer(new int[]{passingFees[v]+cost,v,time+x});
                }
            }
        }
        return -1;
    }
}