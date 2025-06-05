class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] p:prerequisites){
            int u = p[0];
            int v = p[1];
            adj.get(v).add(u);
        }
        int[] indegree = new int[numCourses];
        for(int i = 0 ;i<numCourses;i++){
            for(int nei:adj.get(i)){
                indegree[nei]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(indegree[i]==0){
                que.offer(i);
            }
        }

        List<Integer> topo = new ArrayList<>();
        int cnt = 0;
        while(!que.isEmpty()){
            int node = que.poll();
            topo.add(node);
            cnt++;
            for(int nei:adj.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    que.add(nei);
                }
            }
        }
        if(cnt!=numCourses) return new int[0];
        int[] course = new int[numCourses];
        for(int i = 0 ;i<topo.size();i++){
            course[i] = topo.get(i);
        }
        return course;

    }
}