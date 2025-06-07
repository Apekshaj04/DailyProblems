class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();
        int n1 = s.length();
        int n2 = t.length();
        for(int i = 0;i<n1;i++){
            if(s.charAt(i)!='#'){
                stk1.push(s.charAt(i));
            }
            else{
                if(!stk1.isEmpty()){

                    stk1.pop();
                }
            }
        }
        for(int i = 0;i<n2;i++){
            if(t.charAt(i)!='#'){
                stk2.push(t.charAt(i));
            }
            else{
                if(!stk2.isEmpty()){
                    stk2.pop();

                }
            }
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while(!stk1.isEmpty()){
            sb1.append(stk1.pop());
        }
        while(!stk2.isEmpty()){
            sb2.append(stk2.pop());
        }
        return sb1.toString().equals(sb2.toString());
    }
}