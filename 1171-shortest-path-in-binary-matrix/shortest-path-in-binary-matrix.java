class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n  = grid.length;
        int m = grid[0].length;
        if(grid[0][0]!=0 || grid[n-1][m-1]!=0){
            return -1;
        }
        if(n==1 && m==1) return 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        grid[0][0] =1;
        int maxDist = 0;
        int dist = 1;
        int[][] dir ={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            for(int i =0;i<size;i++){
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];
                for(int[] d:dir){
                    int newX = x + d[0];
                    int newY = y + d[1];
                    if(newX>=0 && newX<n && newY>=0 && newY<m && grid[newX][newY]==0){  
                        if(newX==n-1 && newY==m-1){
                            maxDist = Math.max(maxDist,dist);
                            return dist;
                            
                        }
                        grid[newX][newY] = 1;
                        q.offer(new int[]{newX,newY});
                    }
                }
            }
        }
        return -1;
    }
}