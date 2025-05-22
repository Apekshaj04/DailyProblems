class Solution {
    public int minimumOperations(int[][] grid) {
        int total = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0;i<n;i++){
            int prev = grid[0][i];
            for(int j = 1;j<m;j++){
                if(grid[j][i]<=prev){
                    int x = prev+1;
                    total += x-grid[j][i];
                    prev = x ;
                }
                else{
                    prev = grid[j][i];
                }
            }
        }
        return total;
    }
}