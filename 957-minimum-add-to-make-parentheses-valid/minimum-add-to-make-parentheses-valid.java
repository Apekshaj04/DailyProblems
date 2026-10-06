class Solution {
    public int minAddToMakeValid(String s) {
       int unbalanced = 0;
       Stack<Character> stk = new Stack<>();
       for(char c:s.toCharArray()){
        if(c=='('){
            stk.push(c);
        }
        else{
            if(stk.isEmpty()){
                unbalanced++;
                continue;
            }
            stk.pop();
        }
       }
       unbalanced+=stk.size();
       return unbalanced;
    }
}