class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        while(sb.length()<k){
            char[] s = sb.toString().toCharArray();
            StringBuilder temp = new StringBuilder();
            for(char c:s){
                // System.out.println(c);
                char next = (c=='z')?'a':(char)(c+1);
                // System.out.println(next);
                temp.append(next);
            }
            sb.append(temp);
        }
        String finall = sb.toString();
        return finall.charAt(k-1);
    }
}