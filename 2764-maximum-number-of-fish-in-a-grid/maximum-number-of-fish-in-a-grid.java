class Solution {
    public boolean isSafe(int i ,int j,int[][] grid,boolean[][] visited){
        int n = grid.length;
        int m = grid[0].length;
        return i<n && j<m && i>=0 && j>=0 && grid[i][j]!=0 && 
        !visited[i][j] ;
    }
    public int DFS(int i,int j,int[][] grid,boolean[][] visited){
        visited[i][j] = true;
        int fishCount = grid[i][j];

        if(isSafe(i+1,j,grid,visited)){
            fishCount+=DFS(i+1,j,grid,visited);
        }

        if(isSafe(i-1,j,grid,visited)){
            fishCount+=DFS(i-1,j,grid,visited);
        }
        if(isSafe(i,j+1,grid,visited)){
            fishCount+=DFS(i,j+1,grid,visited);
        }
        if(isSafe(i,j-1,grid,visited)){
            fishCount+=DFS(i,j-1,grid,visited);
        }

        return fishCount;
    }
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0 ;
        boolean[][] visited = new boolean[n][m];
    
        for(int i = 0 ;i<n;i++){
            for(int j = 0 ;j<m;j++){
                if(grid[i][j]!=0 && !visited[i][j]){
                    max = Math.max(max,DFS(i,j,grid,visited));
                }
            }
        }
        return max;
    }
}