class Solution {
    public int binaryGap(int n) {
        int lastIndex = -1;
        int gap = 0;
        String s = String.valueOf(n);
        int i = 0;
        while(n>0){
            if((n&1)==1){
                if(lastIndex!=-1){

                    gap = Math.max(gap,i-lastIndex);
                }
                lastIndex = i;
            }
            i++;
            n>>=1;
        }
        return gap;
    }
}