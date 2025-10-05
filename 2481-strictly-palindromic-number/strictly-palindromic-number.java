class Solution {
    public boolean pallindromic(int base,int pow){
        StringBuilder sb = new StringBuilder();
        while(base>0){
            int rem = base%pow;
            base = base/pow;
            sb.append(rem);
        }
        if(sb.reverse().toString()==sb.toString()) return true;
        return false;

    }
    public boolean isStrictlyPalindromic(int n) {
        for(int i = 2;i<=n-2;i++){
            if(!pallindromic(n,i)) return false;
        }
        return true;
    }
}