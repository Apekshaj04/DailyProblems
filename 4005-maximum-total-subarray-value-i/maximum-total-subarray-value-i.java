class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int num:nums){
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        sum = max-min;
        return sum*k;
        
    }
}