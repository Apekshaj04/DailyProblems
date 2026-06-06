class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left,0);
        Arrays.fill(right,0);

        for(int i = 1;i<n;i++){
            left[i] = nums[i-1] + left[i-1];
        }
        
        for(int i=n-2;i>=0;i--){
            right[i] = nums[i+1] + right[i+1];
        }

        int[] result = new int[n];
        for(int i = 0;i<n;i++){
            result[i] = Math.abs(left[i]-right[i]);
        }
        return result;
    }
}