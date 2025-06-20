class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<n;i++){
            for(int j = 0; j<m;j++){
                if(grid[i][j]==1){
                    q.offer(new int[]{i,j});
                }
        }
        }
        if (q.isEmpty() || q.size() == n * n) return -1;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            for(int i =0;i<size;i++){
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];
                for(int[] d:dir){
                    int newX = x+d[0];
                    int newY = y+d[1];
                    if(newX>=0 && newX<n && newY>=0 && newY<n && grid[newX][newY]==0){
                        grid[newX][newY]=2;
                        q.offer(new int[]{newX,newY});
                    }
                }
            }
        }
        return dist-1;
    }
}