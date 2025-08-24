class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = 0;
        int  left = 0;
        int zeroCount = 0;
        for(int end =0;end<n;end++){
            if(nums[end]==0){
                zeroCount++;
            }
            while(zeroCount>1){
                if(nums[left]==0){
                    zeroCount--;
                }
                left++;
            }
            max = Math.max(max,end-left);
        }
        return max;
    }
}