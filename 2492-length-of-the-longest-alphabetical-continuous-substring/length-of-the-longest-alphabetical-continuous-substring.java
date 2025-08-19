class Solution {
    public int longestContinuousSubstring(String s) {
        int result = 1;
        int n = s.length();
        int i = 0;
        while(i<n){
            int j =i+1;
            while(j<n && s.charAt(j)-s.charAt(j-1)==1){
                j++;
            }
            j--;
            result = Math.max(result,j-i+1);
            i++;
        }
        return result;
        
    }
}