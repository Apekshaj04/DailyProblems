class Solution {
    class Pair{
        int index;
        char ch;
        Pair(char ch,int index){
            this.ch = ch;
            this.index = index;
        }
    }
    public int longestValidParentheses(String s) {
        Stack<Pair> stk = new Stack<>();
        int n = s.length();
        int[] arr = new int[n];
        Arrays.fill(arr,0);
        for(int i = 0;i<n;i++){
            char c = s.charAt(i);
            if(c=='('){
                stk.push(new Pair(c,i));
            }
            else{
                if(!stk.isEmpty() && stk.peek().ch=='('){
                    Pair p =  stk.pop();
                    arr[i]=1;
                    arr[p.index] =1;
                }
            }
        }
        int longest = 0;
        int cnt = 0;
        for(int i =0;i<n;i++){
            if(arr[i]==1){
                cnt++;
                longest = Math.max(longest,cnt);
            }
            else{
                cnt = 0;
            }
          
        }
        return longest;
    }
}