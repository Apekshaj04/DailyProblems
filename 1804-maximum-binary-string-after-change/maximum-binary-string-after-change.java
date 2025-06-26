class Solution {
    public String maximumBinaryString(String binary) {
        int n  = binary.length();
        int zero =0;
        for(char c:binary.toCharArray()){
            if(c=='0'){
                zero++;
            }
        }
        if(zero<2) return binary;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            sb.append('1');
        }
        for(int i = 0;i<n;i++){
            if(binary.charAt(i)=='0'){
                sb.setCharAt(i+zero-1,'0');
                return sb.toString();
            }
        }
        return sb.toString();
    }
}