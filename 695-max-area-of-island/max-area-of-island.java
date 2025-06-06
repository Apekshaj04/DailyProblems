class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = {
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
        };
        int cnt = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    cnt= Math.max(dfs(grid,visited,i,j,dir),cnt);
                }
            }
        }

        return cnt ;
    }
public boolean isSafe(int[][] grid,boolean[][] visited,int i,int j){
    int n = grid.length;
    int m = grid[0].length;
    return i<n && i>=0 && j>=0 && j<m && !visited[i][j] && grid[i][j]==1;
}
    public int dfs(int[][] grid,boolean[][] visited,int i ,int j,int[][] dir){
        visited[i][j] = true;
        int cnt = 1;
        for(int[] d:dir){
            int newX = d[0]+i;
            int newY = d[1] + j ;
            if(isSafe(grid,visited,newX,newY)){
                cnt+=dfs(grid,visited,newX,newY,dir);
            }
        }
        return cnt; 
    }
}