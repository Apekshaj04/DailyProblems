class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        Map<Integer, Integer> map = new HashMap<>();

        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());
        }

        int counter = 0;
        int total = n * m;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tempCalc = (counter + k) % total;
                map.put(tempCalc, grid[i][j]);
                counter++;
            }
        }

        counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix.get(i).add(map.get(counter));
                counter++;
            }
        }

        return matrix;
    }
}