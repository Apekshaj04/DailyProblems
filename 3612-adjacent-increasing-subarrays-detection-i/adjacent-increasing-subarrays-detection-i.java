class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n  = nums.size();        
        for(int i = 0;i<=n-2*k;i++){
            boolean flag = true;
            for(int j = i+1;j<i+k;j++){
                if(nums.get(j-1)>=nums.get(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                for(int j = i+k+1;j<i+2*k;j++){
                    if(nums.get(j-1)>=nums.get(j)){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) return true;
        }
        return false;
    }
}