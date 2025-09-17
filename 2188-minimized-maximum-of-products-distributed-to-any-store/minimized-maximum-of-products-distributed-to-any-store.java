class Solution {
    public int allocate(int[] quantities,int mid){
        int stores = 0;
        int n = quantities.length;
        for(int q:quantities){
           stores+=(q+mid-1)/mid;
        }
        return stores;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = 0;
        for(int q:quantities){
            high = Math.max(high,q);
        }
        int ans = high;
        while(low<=high){
            int mid = low+(high-low)/2;
            int required = allocate(quantities,mid);
            if(required<=n){
                high = mid-1;
                ans = mid;
            }
            else{
                low= mid+1;
            }
        }
        return ans;
    }
}