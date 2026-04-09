class Solution {
        int MOD = 1_000_000_007;
    private void divideConquer(int[] nums,int l,int r,int k,int v){
        if(l>r) return ;

        if(l<=r){
            // System.out.println(l);
            divideConquer(nums,l+k,r,k,v);
            nums[l] = (int)(((long) nums[l]*v)%MOD);
        }
    }
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] q:queries){
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];
            divideConquer(nums,l,r,k,v);
        }
        int ans = nums[0];
        int n = nums.length;
        for(int i = 1;i<n;i++){
            ans^=nums[i];
        }
        return ans;
        
    }
}