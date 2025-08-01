import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (numRows < 1) {
            return new ArrayList<>();
        } else if (numRows == 1) {
         
            res.add(new ArrayList<>(Arrays.asList(1)));
            return new ArrayList<>(res);
        } else if (numRows == 2) {
       
            res.add(new ArrayList<>(Arrays.asList(1)));
            res.add(new ArrayList<>(Arrays.asList(1, 1)));
            return new ArrayList<>(res);
        } else {
   
            int[][] dp = new int[numRows][numRows];

            for (int i = 0; i < numRows; i++) {
                Arrays.fill(dp[i], -1);
            }

   
            for (int i = 0; i < numRows; i++) {
                dp[i][0] = 1; 
                dp[i][i] = 1;
                for (int j = 1; j < i; j++) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; 
                }
            }

          
            for (int i = 0; i < numRows; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    row.add(dp[i][j]);
                }
                res.add(row);
            }
        }

        return new ArrayList<>(res); 
    }
}
