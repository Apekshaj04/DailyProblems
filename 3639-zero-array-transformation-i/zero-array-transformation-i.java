class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n  = nums.length;
        int m = queries.length;
        int[] delta = new int[n+1];
        for(int i = 0;i<m;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            delta[left] += 1;
            delta[right+1] -=1 ;

        }
        int[] prefix = new int[n+1];
        int cnt = 0;
        for(int i = 0;i<=n;i++){
            cnt += delta[i];
            prefix[i] = cnt;
        }
        for(int i = 0;i<n;i++){
            if(prefix[i]<nums[i]){
                return false;
            }
        }
        return true;
    }
}