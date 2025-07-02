class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(String w : words){
            StringBuilder temp = new StringBuilder(w);
            sb.append(temp.reverse().toString()+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
        
    }
}