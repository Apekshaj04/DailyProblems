class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        int open = 0;
        int openIndex= -1,closeIndex=-1;
        for(int i = 0;i<n;i++){
            char c =s.charAt(i);
            if(c=='('){
                open++;
                if(open==1) openIndex= i;
            }
            else{
                open--;
                if(open==0){
                    closeIndex =i;
                    sb.append(s.substring(openIndex+1,closeIndex));
                }
            }
        }
        return sb.toString();
    }
}