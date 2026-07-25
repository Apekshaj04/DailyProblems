class Solution {
    public int maxProduct(int n) {
        List<Integer> digits = new ArrayList<>();
        while(n!=0){
            int rem = n%10;
            digits.add(rem);
            n=n/10;
        }
        Collections.sort(digits,Collections.reverseOrder());
        return digits.get(0)*digits.get(1);
        
    }
}