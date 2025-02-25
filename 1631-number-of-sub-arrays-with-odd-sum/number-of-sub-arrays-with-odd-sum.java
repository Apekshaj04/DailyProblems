class Solution {
    static final int MOD = 1000000007;
    public int numOfSubarrays(int[] arr) {
        int total = 0;
        int prefixSum = 0;
        int even = 1;
        int odd = 0 ;

        for(int i = 0;i<arr.length;i++){
            prefixSum += arr[i];
            if(prefixSum%2==0){
                total+=odd;
                even++;
            }
            else{
                total+=even;
                odd++;
            }
            total = total%MOD;
        }
        
        return total % MOD;

    }
}