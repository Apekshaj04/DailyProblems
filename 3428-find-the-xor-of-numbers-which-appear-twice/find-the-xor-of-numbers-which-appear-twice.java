class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n :nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int xor = 0;
        for(Map.Entry<Integer,Integer> mpp:map.entrySet()){
            if(mpp.getValue()==2){
                xor^=mpp.getKey();

            }
        }
        return xor;
    }
}