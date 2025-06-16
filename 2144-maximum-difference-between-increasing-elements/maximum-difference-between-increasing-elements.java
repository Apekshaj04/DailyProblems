class Solution {
    public int maximumDifference(int[] nums) {
        int max = -1;
        int n = nums.length;
        int[] arr = new int[n];
        arr[n-1] = nums[n-1];
        for(int i = n-2;i>=0;i--){
            arr[i] = Math.max(arr[i+1],nums[i]);
        }

        for(int i =0;i<n-1;i++){
            if(arr[i]>nums[i]){

            max = Math.max(max,arr[i]-nums[i]);
            }
        }
        return max;
    }
}