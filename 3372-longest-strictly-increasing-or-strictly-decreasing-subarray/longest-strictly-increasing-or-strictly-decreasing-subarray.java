class Solution {

    public int strictlyIncreasing(int[] nums){
        int n = nums.length;
        int i = 0;
        int j = 1;
        int length = 0;
        if(n==0) return 0 ;
        while(j<n){
            if(j<n && nums[j-1]<nums[j]){
                j++;
            }
            else{
                length = Math.max(length,j-i);
                i = j;
                j++;
            }
        }
        length = Math.max(length,j-i);
        return length;
    }
    public int strictlyDecreasing(int[] nums){
        int n = nums.length;
        int i = 0;
        int j = 1;
        int length = 0;
        if(n==0) return 0 ;
        while(j<n){
            if(nums[j-1]>nums[j]){
                j++;
            }
            else{
                length = Math.max(length,j-i);
                i = j;
                j++;
            }
        }
        length = Math.max(length,j-i);
        return length;
    }
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int i = 0 ;
        int j  = 1;
        int l1 = strictlyIncreasing( nums);
        int l2 = strictlyDecreasing( nums);
        return Math.max(l1,l2);
    }
}