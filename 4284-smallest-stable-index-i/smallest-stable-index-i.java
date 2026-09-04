class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] maxArray = new int[n];
        int[] minArray = new int[n];
        maxArray[0] = nums[0];
        minArray[n-1] = nums[n-1];
        for(int i = 1;i<=n-1;i++){
            maxArray[i] = Math.max(maxArray[i-1],nums[i]);
        }
        for(int i= n-2;i>=0;i--){
            minArray[i] = Math.min(minArray[i+1],nums[i]);
        }

        for(int i = 0 ;i<n;i++){
            int score = maxArray[i]-minArray[i];
            if(score<=k){
                return i;
            }
        }
        return -1;
    }
}