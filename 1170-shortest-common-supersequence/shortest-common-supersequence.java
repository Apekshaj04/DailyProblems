class Solution {
    public String findLCS(String str1, String str2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return lcs.reverse().toString();
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        String res = findLCS(str1, str2, str1.length(), str2.length());
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        for(char c:res.toCharArray()){
            while(i<str1.length() && str1.charAt(i)!=c){
                sb.append(str1.charAt(i));
                i++;
            }
             while(j<str2.length() && str2.charAt(j)!=c){
                sb.append(str2.charAt(j));
                j++;
            }
            sb.append(c);
            i++;
            j++;
        }
        sb.append(str1.substring(i));
        sb.append(str2.substring(j));
        return sb.toString();

     
    }
}