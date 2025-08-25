class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int flag = 1;
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        int lastI = 0;
        int lastJ = 0;
        res.add(mat[0][0]);
        while (!(i == n - 1 && j == m - 1)) {
            if (flag == 1) { 
                if (j + 1 < m) { 
                    lastI = i;
                    lastJ = j + 1;
                } else { 
                    lastI = i + 1;
                    lastJ = j;
                }

                while (lastI < n && lastJ >= 0) {
                    res.add(mat[lastI][lastJ]);
                    lastI++;
                    lastJ--;
                }
                lastI--;
                lastJ++;
            } else {
                if (i + 1 < n) { 
                    lastI = i + 1;
                    lastJ = j;
                } else { 
                    lastI = i;
                    lastJ = j + 1;
                }

                while (lastI >= 0 && lastJ < m) {
                    res.add(mat[lastI][lastJ]);
                    lastI--;
                    lastJ++;
                }
                lastI++;
                lastJ--;
            }

            i = lastI;
            j = lastJ;
            flag = (flag == 1) ? 0 : 1; 
        }

        int[] result = new int[res.size()];
        for (int k = 0; k < res.size(); k++) {
            result[k] = res.get(k);
        }
        return result;
    }
}
