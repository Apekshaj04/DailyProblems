class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result= new int[n];
        for(int i= 0;i<n;i++){
            int flag=0;
            for(int j = i+1;j<n;j++){
                if(prices[j]<=prices[i]){
                    result[i] = prices[i]-prices[j];
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                result[i]=prices[i];
            }        
        }
        return result;
    }
}