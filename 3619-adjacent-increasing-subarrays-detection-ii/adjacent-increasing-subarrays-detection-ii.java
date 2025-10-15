class Solution {
    public boolean isPossible(List<Integer>nums,int k,int[] precompute){
        int n = nums.size();
        for(int i = 0;i<=n-2*k;i++){
            if(precompute[i]>=k && precompute[i+k]>=k){
                return true;
            }
        }
        return false;
    }
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int low = 1;
        int high = n/2;
        int ans = -1;
       
          int[] inc = new int[n];
        inc[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                inc[i] = inc[i + 1] + 1;
            } else {
                inc[i] = 1;
            }
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(nums,mid,inc)){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}