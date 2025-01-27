import java.util.*;

class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) { 
        boolean[][] reachable = new boolean[n][n];
        
        for (int[] edge : prerequisites) {
            reachable[edge[0]][edge[1]] = true;
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) { 
                for (int j = 0; j < n; j++) {
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }
        
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(reachable[query[0]][query[1]]);
        }
        
        return res; 
    }
}
