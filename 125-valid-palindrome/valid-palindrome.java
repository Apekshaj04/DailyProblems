class Solution {
    public boolean isPalindrome(String s) {
        String res = s.replaceAll("[^A-Za-z0-9]","");
        int n = res.length();
        StringBuilder sb = new StringBuilder(res);
        for(int i =0;i<n;i++ ){
            char c =  Character.toLowerCase(sb.charAt(i));
            sb.setCharAt(i,c);
        }
        System.out.println(sb);
        for(int i = 0 ;i<n/2;i++){
            if(sb.charAt(i)!=sb.charAt(n-i-1)){
                    return false;
            }
        }
        return true ; 
    }
}