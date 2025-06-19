class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int cnt  =  0 ;
        int i = 0;
       while(i<n){
            int min = nums[i];
            int j = i;
            while(j<n){
                if(nums[j]-min>k){
                    break;
                }
                j++;

            }
            cnt++;
            i = j;


        }
        return cnt;
    }
}