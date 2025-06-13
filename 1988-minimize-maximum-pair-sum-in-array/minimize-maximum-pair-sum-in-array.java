class Solution {
    public int minPairSum(int[] nums) {
        int maxVal = 0;
        for(int n : nums){
            maxVal = Math.max(n,maxVal);
        }
        int[] bucket = new int[maxVal+1];
        int left = 0;
        int right = maxVal;
        for(int n :nums){
            bucket[n]++;
        }
        int maxSum = 0;
        while(left<right){
            while(bucket[left]==0) left++;
            while(bucket[right]==0) right--;
            maxSum = Math.max(maxSum,left+right);
            if(bucket[left]>bucket[right]){
                bucket[left] = bucket[left] - bucket[right];
                right--;
            }
            else if(bucket[right]>bucket[left]){
                bucket[right] = bucket[right] - bucket[left];
                left++;
            }
            else{
                left++;
                right--;
            }
        }
        return maxSum ; 
        
    }
}