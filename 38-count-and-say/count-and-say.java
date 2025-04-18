class Solution {
    public String buildString(String s){
        int n = s.length();
        int i = 0;
        StringBuilder res = new StringBuilder("");
        while(i<n){
            char currentChar = s.charAt(i);
            int count = 0 ;
            while(i<n && s.charAt(i)==currentChar){
                i++;
                count++;
            }
            res.append(count);
            res.append(currentChar);
        }
        return res.toString();

    }
    public String count(int n,String current){
        if(n==1){
            return current;
        }
       return  count(n-1,buildString(current));
    }
    public String countAndSay(int n) {
        return count(n,"1");
    }
}