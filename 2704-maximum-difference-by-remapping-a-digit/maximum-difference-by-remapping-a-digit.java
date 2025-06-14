class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        int max = 0;
        int min = Integer.MAX_VALUE;
        int n = s.length();
        for(int i = 0 ;i<n;i++){
            char c = s.charAt(i);
            for(int j= 0 ;j<=9;j++){
                String newS = s.replace(c,(char)(j+'0'));
                int x  = Integer.parseInt(newS);
                max = Math.max(max,x);
                min = Math.min(min,x);                
            }
        }
        return max-min;
    }
}