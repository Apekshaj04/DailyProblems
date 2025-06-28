class Solution {
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] res = new int[n+1];
        res[0] = first;
        for(int i = 1;i<encoded.length;i++){
            res[i] = res[i-1]^encoded[i-1];
        }
        res[n] = res[n-1]^encoded[n-1];
        return res;
    }
}