class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> results = new ArrayList<>();
        if(expression.length()==0) return results;
        if(expression.length()==1){
            results.add(Integer.parseInt(expression));
            return results;
        }
        if(expression.length()==2 && Character.isDigit(expression.charAt(0))){
            results.add(Integer.parseInt(expression));
            return results;
        }
        for(int i = 0;i<expression.length();i++){
            char current = expression.charAt(i);
            if(Character.isDigit(expression.charAt(i))) continue;
            List<Integer> leftResults = diffWaysToCompute(expression.substring(0,i));
            List<Integer> rightResults = diffWaysToCompute(expression.substring(i+1));
            for(int leftValue:leftResults){
                for(int rightValue:rightResults){
                    int compute = 0;
                    switch(current){
                        case '+':
                            compute = leftValue + rightValue;
                            break;
                        case '-':
                            compute = leftValue - rightValue;
                            break;
                        case '*':
                            compute = leftValue * rightValue;
                            break;
                    }
                    results.add(compute);
                }
            }
        }
        return results;
    }
}