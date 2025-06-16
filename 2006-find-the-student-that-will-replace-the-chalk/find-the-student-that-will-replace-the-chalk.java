class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int sum = 0;
        int n = chalk.length;
        
        for(int c:chalk){
            sum+=c;
        }
        if(sum==k) return 0;
        int div = k/sum;

        if(div<=0 || sum<k){
            for(int i = 0;i<n;i++){
                if(k<chalk[i]) return i;
                k-=chalk[i];
            }
        }
        int temp = k%sum;
        for(int i= 0;i<n;i++){
            if(temp<chalk[i]) return i;
            temp-=chalk[i];
        }
        return 0;
    }
}