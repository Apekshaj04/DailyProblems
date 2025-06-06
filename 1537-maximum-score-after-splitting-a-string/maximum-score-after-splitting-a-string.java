class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int total_zeros = 0;
        int total_ones = 0;
        for(char c:s.toCharArray()){
            if(c=='0'){
                total_zeros++;
            }
            else{
                total_ones++;
            }
        }
        int zero = 0;
        int one = 0;
      
        int cost = 0 ;
        for(int i = 0;i<n-1;i++){
            char c = s.charAt(i);
            if(c=='0'){
                zero++;
            }
            else{
                one++;
            }
            cost = Math.max(cost,zero+(total_ones-one));

        }
        return cost;
    }
}
