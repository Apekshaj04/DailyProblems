class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int m = queries.length;
        int[][] arr = new int[n][n];
        for(int i =0 ;i<n;i++){
            Arrays.fill(arr[i],0);
        }
        for(int i= 0 ;i<m;i++){
            int rs = queries[i][0];
            int re = queries[i][2];
            int cs = queries[i][1];
            int ce = queries[i][3];
            for(int j = rs;j<=re;j++){
                for(int k = cs;k<=ce;k++){
                    arr[j][k]+=1;
                }
            }
        }
        return arr;
    }
}