class Solution {
    public boolean canformpairs(int mid ,int p,int[] nums ){
        int cnt = 0;
        int i = 0;
        int n = nums.length;
        while(i<n-1){
            if(nums[i+1]-nums[i]<=mid){
                cnt++;
                i+=2;
            }
            else{
                i+=1;
            }
        }
        return cnt>=p;
        
    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int left  = 0;
        int right = nums[n-1]-nums[0];
        int i = 0;
        while(left<right){
            int mid = (left + right)/2;
            if(canformpairs(mid,p,nums)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}