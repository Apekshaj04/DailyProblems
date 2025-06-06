class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n+1];
        for(int i = 1;i<=n;i++){
            prefixSum[i] = prefixSum[i-1]+nums[i-1];
        }
        int total = 0;
        for(int y:nums){
            total+=y;
        }
        int x = 0,prev = 0 ;
        for(int i = 0;i<n;i++){
             x = total - prefixSum[i+1];
             prev = prefixSum[i];
             if(x==prev){
                return i;
             }
        }
        return -1;
    }
}