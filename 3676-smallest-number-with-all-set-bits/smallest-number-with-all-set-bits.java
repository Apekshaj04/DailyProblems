class Solution {
    public int smallestNumber(int n) {
        int nod = 0 ;
        while(n>0){
            nod++;
            n>>=1;
        }
        return (int) Math.pow(2,nod)-1;
    }
}