class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1) return true;
        int left = 1;
        int  right  = num/2;
        while(left<=right){
            int mid = left + (right-left)/2;
            long temp =(long) mid*mid ;
            if(temp==num) return true ;
            if(temp>num){
                right = mid -1;
            }
            else{
                left = mid+1;
            }

        }
        return false;
    }
}