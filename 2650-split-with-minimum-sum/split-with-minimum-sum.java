class Solution {
    public int splitNum(int num) {
        String s = String.valueOf(num);
        char[] c= s.toCharArray();
        Arrays.sort(c);
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        for(int i = 0;i<c.length;i++){
            if(i%2==0){
                num1.append(c[i]);
            }
            else{
                num2.append(c[i]);
            }
        }
        return Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
    }
}