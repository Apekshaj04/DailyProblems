class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        if(n<=1){
            return n;
        }
        int cnt = 1;
        char prev = word.charAt(0);
        int cons = 1;
        for(int i = 1;i<n;i++){
            char c = word.charAt(i);
            if(c==prev){
                cons++;
            }
            else{
                if(cons>1){
                    cnt+=cons-1;
                }
                prev = c;
                cons = 1;
            }
        }
        if(cons>1){
            cnt+=cons-1;
        }
        return cnt;
        
    }
}