class Solution {
    public long zeroFilledSubarray(int[] arr) {
        int n = arr.length;
        int i = 0;
        long res = 0;
        while(i<n){
            if(arr[i]!=0){
                i++;
                continue;
            }
            int j = i+1;
            while(j<n && arr[j]==0){
                j++;
            }
            j--;          
            int m = (j-i+1);
            res +=(long) m*(m+1)/2;
            i=j+1;
        }
        return res;
        
    }
}