class Solution {
    private boolean isSelfDividing(int n){
        int number = n;
        while(n>0){
            int rem = n%10;
            if(rem==0 || number%rem!=0 ){
                return false;
            }
            n = n/10;

        }
        return true;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(isSelfDividing(i)){
                result.add(i);
            }
        }
        return result;
    }
}