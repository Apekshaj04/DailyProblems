class Solution {    
    static int n1,m1;
    public int[] count(String word){
        int zero = 0 ;
        int ones = 0;
        for(char c:word.toCharArray()){
            if(c=='0'){
                zero++;
            }
            else{
                ones++;
            }
        }
        return new int[]{zero,ones};

    }
    public int function(String[] strs,int[][][] dp,int index,int zeros,int ones){
        if(index>=strs.length){
            return 0;
        }
        if(dp[index][zeros][ones]!=-1) return dp[index][zeros][ones];
        int take = 0;
        int[] count = count(strs[index]);
        if(zeros+count[0]<=m1 && ones+count[1]<=n1){
            take = function(strs,dp,index+1,zeros+count[0],ones+count[1])+1;
        }
        int notTake = function(strs,dp,index+1,zeros,ones);
        return dp[index][zeros][ones] = Math.max(take,notTake);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        m1 = m;
        n1 = n;
        int len = strs.length;
        int[][][] dp = new int[len+1][m+1][n+1];
        for(int i = 0;i<=len;i++){
            for(int j=0;j<=m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return function(strs,dp,0,0,0);
        
    }
}