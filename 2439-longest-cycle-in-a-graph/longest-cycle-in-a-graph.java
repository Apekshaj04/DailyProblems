class Solution {
    public int longestCycle(int[] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        int n = edges.length;
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            if(edges[i]!=-1){
                adj.get(i).add(edges[i]);
                rev.get(edges[i]).add(i);
            }
        }
        Stack<Integer>  stack = new Stack<>();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                dfs(i,visited,adj,stack);
            }
        }
        Arrays.fill(visited,false);
        int maxi = -1;
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(!visited[node]){
                ArrayList<Integer> component = new ArrayList<>();
                dfsReverse(node,visited,rev,component);
                if(isCycle(component,edges)){

                    maxi = Math.max(component.size(),maxi);                
                }
            }
        }
        return maxi;
    }
    public void dfsReverse(int node,boolean[] visited,ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> component){
        visited[node] = true;
        component.add(node);
        for(int nei:graph.get(node)){
            if(!visited[nei]){
                dfsReverse(nei,visited,graph,component);
            }
        }
    }
    public void dfs(int node,boolean[] visited,ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack){
        visited[node] = true;
        for(int nei:adj.get(node)){
            if(!visited[nei]){
                dfs(nei,visited,adj,stack);
            }
        }
        stack.push(node);
    }
 public boolean isCycle(ArrayList<Integer> component, int[] edges) {
        Set<Integer> set = new HashSet<>(component);
        for (int node : component) {
            if (edges[node] == -1 || !set.contains(edges[node])) {
                return false;
            }
        }
        return true;
    }
}