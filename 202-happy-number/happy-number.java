class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = calculate(slow);
            fast = calculate(calculate(fast));
        }
        while(slow!=fast);
        if(slow==1) return true;
        return false;
    }
    int calculate(int n ){
        int temp = n;
        int res =0;
        while(temp!=0){
            int rem = temp%10;
            res+=rem*rem;
            temp/=10;
        }
        return res;
    }
}