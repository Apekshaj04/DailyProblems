class Solution {
    public boolean isPrime(int n) {
        if (n < 2) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public int maximumPrimeDifference(int[] nums) {
        int n = nums.length;
        int left = 0 ;
        int right = n-1;
        int maxDiff = 0;
        while(left<right){
            if(!isPrime(nums[left])){
                left++;
            }
            else if(!isPrime(nums[right])){
                right--;
            }
            else{
                maxDiff = Math.max(maxDiff,right-left);
                right--;
                left++;
            }
        }
        return maxDiff;
    }
}