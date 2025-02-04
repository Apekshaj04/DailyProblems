class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        int j  = 1;
        int i = 0;
        int sum = nums[0];
        int lsum = 0;

        while(j<n){
            if(nums[j]>nums[j-1]){
                sum+=nums[j];
            }
            else{
                lsum = Math.max(lsum,sum);
                sum = nums[j] ;
                i = j;
            }
            j++;
        }
        lsum = Math.max(lsum,sum);
        return lsum ;
    }
}