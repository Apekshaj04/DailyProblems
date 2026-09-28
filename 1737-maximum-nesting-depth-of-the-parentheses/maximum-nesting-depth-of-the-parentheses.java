class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0 ;
        int opening = 0;
        int n = s.length();
        for(int i = 0;i<n;i++){
            if(s.charAt(i)=='('){
                opening++;
                maxDepth = Math.max(maxDepth,opening);
            }
            else if(s.charAt(i)==')'){
                opening--;
            }
            else{
                continue;
            }
        }
        return maxDepth;
        
    }
}