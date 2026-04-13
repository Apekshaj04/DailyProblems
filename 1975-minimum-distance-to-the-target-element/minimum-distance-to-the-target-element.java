class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int miniDist = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(nums[i]==target){
                int temp = Math.abs(i-start);
                miniDist = Math.min(miniDist,temp);
            }
        }
        return miniDist;
        
    }
}