import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        for (int startCol = 1; startCol < n; startCol++) {
            ArrayList<Integer> arr = new ArrayList<>();
            int r = 0, c = startCol;
            while (r < n && c < n) {
                arr.add(grid[r][c]);
                r++;
                c++;
            }
            Collections.sort(arr);
            r = 0; c = startCol;
            int idx = 0;
            while (r < n && c < n) {
                grid[r][c] = arr.get(idx++);
                r++;
                c++;
            }
        }

        for (int startRow = 0; startRow < n; startRow++) {
            ArrayList<Integer> arr = new ArrayList<>();
            int r = startRow, c = 0;
            while (r < n && c < n) {
                arr.add(grid[r][c]);
                r++;
                c++;
            }
            Collections.sort(arr, Collections.reverseOrder()); 
            r = startRow; c = 0;
            int idx = 0;
            while (r < n && c < n) {
                grid[r][c] = arr.get(idx++);
                r++;
                c++;
            }
        }

        return grid;
    }
}
