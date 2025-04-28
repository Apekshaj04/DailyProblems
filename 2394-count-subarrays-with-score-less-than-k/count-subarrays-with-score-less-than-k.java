class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        if(n==1){
            return nums[0]<k?1:0;
        }
        long cnt = 0 ;
        int i = 0;
        int j = 0;
        long sum =0;
        while(j<n){
            sum+=nums[j];
          
          
            while(i<=j && sum*(j-i+1)>=k){
                sum -=nums[i];
                i++;
                
            }
            cnt+=j-i+1;        
            j++;

        }   
  
        return cnt;


    }
}