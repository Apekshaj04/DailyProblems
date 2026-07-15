class Solution {
    public int gcd(int a,int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a= temp;
        }
        return a;
    }
    public int gcdOfOddEvenSums(int n) {
        int sumEven =0 , sumOdd= 0;
        int doub = 2*n;
        for(int i =0;i<=doub;i++){
            if(i%2==0){
                sumEven+=i;
            }
            else{
                sumOdd+=i;
            }
        }
        int result = gcd(sumEven,sumOdd);
        return result;
        
    }
}