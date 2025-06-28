class Solution {
    public boolean hasAlternatingBits(int n) {
        int last =-1;
        while(n>0){
            int pres = (n&1);
            if(last==pres) return false;
            last = pres;
            n>>=1;
        }
        if(last==-1){
            return false;
        }
        else{
            return true;
        }
    }
}