class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        int low = 0;
        int high = n-1;
        int h = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(citations[mid]>=n-mid){
                h = Math.max(h,n-mid);
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return h;
    }
}