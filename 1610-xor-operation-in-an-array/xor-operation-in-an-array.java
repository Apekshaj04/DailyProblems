class Solution {
    public int xorOperation(int n, int start) {
        int high = start+2*n;
        int xor = 0;
        for(int i = start;i<high;i+=2){
            xor^=i;
        }
        return xor;
    }
}