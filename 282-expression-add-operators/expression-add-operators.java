class Solution {
    public boolean eval(String s, int target) {
        Stack<Character> ops = new Stack<>();
        Stack<Long> nums = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int start = i;
                long num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    if (num > Integer.MAX_VALUE) {
                        return false;
                    }
                    i++;
                }
                String numStr = s.substring(start, i);
                if (numStr.length() > 1 && numStr.charAt(0) == '0') {
                    return false;
                }
                nums.push(num);
            } else if (isOperator(c)) {
                while (!ops.isEmpty() && hasP(ops.peek(), c)) {
                    long num2 = nums.pop();
                    long num1 = nums.pop();
                    char op = ops.pop();
                    long result = applyOp(num1, num2, op);
                    if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
                        return false;
                    }
                    nums.push(result);
                }
                ops.push(c);
                i++;
            } else {
                i++;
            }
        }
        
        while (!ops.isEmpty()) {
            long num2 = nums.pop();
            long num1 = nums.pop();
            char op = ops.pop();
            long result = applyOp(num1, num2, op);
            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
                return false;
            }
            nums.push(result);
        }
        
        return nums.pop() == target;
    }
    
    public boolean isOperator(char c){
        if(c=='+' || c=='-' || c=='*' || c=='/') return true;
        return false;
    }
    
    private boolean hasP(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) return true;
        if ((op1 == '+' || op1 == '-') && (op2 == '*' || op2 == '/')) return false;
        return true;
    }
    
    public long applyOp(long num1, long num2, char c){
        switch(c){
            case '+' : return num1+num2;
            case '-' : return num1-num2;
            case '*' : return num1*num2;
            case '/' : return num2!=0?num1/num2:0;
        }
        return 0 ;
    }
    
    public List<String> addOperators(String num, int target) {
        List<Character> operators = new ArrayList<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        List<String> result = new ArrayList<>();
        function(target,result,0,operators,new StringBuilder(num));
        return result;
    }
    
    public void function(int target,List<String> result,int index,List<Character> operators,StringBuilder sb){
        if(index>=sb.length()-1){
            if(eval(sb.toString(),target)){
                result.add(sb.toString());
            }
            return ;
        }
        for(char c: operators){
            sb.insert(index+1,c);
            function(target,result,index+2,operators,sb);
            sb.deleteCharAt(index+1);
        }
        function(target,result,index+1,operators,sb);
    }
}