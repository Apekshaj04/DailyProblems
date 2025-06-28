class Solution {
    public int numberOfSteps(int n) {
        if(n==0) return 0;
        int steps = 1;
        while(n>1){
            if((n&1)==0){
                n = n/2;
            }
            else{
                n-=1;
            }
            steps++;
        }
        return steps;
    }
}