class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int cost = 0;
        int last = nums[0];
        for(int i = 1;i<n;i++){
            if(nums[i]<=last){
                cost += last-nums[i]+1;
                last = last+1;
            }
            else{
                last = nums[i];
            }
        }
        return cost;
    }
}