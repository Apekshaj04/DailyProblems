class Solution {
    boolean generatePower(int base ,int e,int n ){
        long term = (long) Math.pow(base,e);
        if(term>n){
            return false;
        }
        if(term==n){
            return true;
        }
        return generatePower(base,e+1,n);
    }
    public boolean isPowerOfThree(int n) {
        return generatePower(3,0,n);
    }
}
