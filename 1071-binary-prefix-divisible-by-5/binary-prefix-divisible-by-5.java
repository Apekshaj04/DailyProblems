class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int res = 0;
        List<Boolean> result = new ArrayList<>();
        for(int bit:nums){
            res = ((res<<1)+bit)%5;
            result.add(res==0);            
        }
        return result;
    }
}