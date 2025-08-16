class Solution {
    public int maximum69Number (int num) {
        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        for(int i =0;i<n;i++){
            if(s.charAt(i)=='6'){
                sb.setCharAt(i,'9');
                break;
            }
        }
        int no = Integer.parseInt(sb.toString());
        return no;
        
    }
}