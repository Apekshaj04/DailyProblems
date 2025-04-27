class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        if(n<3){
            return 0 ;
        }
        int cnt = 0;
        for(int i =0 ;i<=n-3;i++){
            int sum = nums[i]+nums[i+2];
            if(sum*2==nums[i+1]){
                cnt++;
            }
        }
        return cnt; 
    }
}