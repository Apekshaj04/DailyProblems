class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        // if(q.isEmpty() || q.size()==n*m) return -1;
        int[][] dir ={{1,0},{-1,0},{0,1},{0,-1}};
        int dist = -1;
        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            for(int i = 0;i<size;i++){
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];
                for(int[] d:dir){
                    int newX =  x+d[0];
                    int newY = y+d[1];
                    if(newX>=0 && newX<n && newY>=0 && newY<m && grid[newX][newY]==1){  
                        grid[newX][newY] =2;
                        q.offer(new int[]{newX,newY});
                    }
                }
            }
        }
        for(int i = 0;i<n;i++){
            for(int j= 0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return dist>0?dist:0;
    }
}