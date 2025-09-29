class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int closest = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0;i<=n-3;i++){
            int temp = nums[i];
            int j = i+1;
            int k = n-1;
            if(i>0 && nums[i]==nums[i-1]) continue;
            while(j<k){
                int tempSum = nums[i]+nums[j]+nums[k];
                if(tempSum==target){
                    return target;
                }
                int tempDiff = Math.abs(tempSum-target);
                if(tempDiff<diff){
                    diff = tempDiff;
                    closest = tempSum;
                }
                if(tempSum>target){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return closest; 
    }
}