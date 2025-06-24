class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] arr = new int[n];
        arr[n-1] = prices[n-1];
        for(int i =n-2;i>=0;i--){
            arr[i] = Math.max(arr[i+1],prices[i]);
        }
        int max = 0;
        for(int i = 0;i<n;i++){
            max = Math.max(max,arr[i]-prices[i]);
        }
        return max;
    }
}