class Solution {
    int countOnes(int n){
        int cnt =0 ;
        while(n>0){
            cnt+=(n&1);
            n>>=1;
        }
        return cnt;
    }
    boolean isPrime(int x){
        if(x<=1) return false;
        if(x<=3) return true;
        if(x%3==0 || x%2==0) return false;
        for(int i =5;i*i<x;i++){
            if(x%i==0 && x%(i+2)==0){
                return false;
            }
        }
        return true;
    }
    public int countPrimeSetBits(int left, int right) {
        int cnt = 0;
        for(int i = left;i<=right;i++){
            int x = countOnes(i);
            if(isPrime(x)){
                cnt++;
            }
        }
        return cnt;
    }
}