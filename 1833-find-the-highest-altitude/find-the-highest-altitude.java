class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] prefix = new int[n+1];
        Arrays.fill(prefix,0);
        int maxi = 0;
        for(int i = 0;i<n;i++){
            prefix[i+1] = prefix[i] + gain[i];
            maxi = Math.max(maxi,prefix[i+1]);
        }
        return maxi;

    }
}