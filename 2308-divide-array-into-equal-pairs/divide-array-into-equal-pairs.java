class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        int temp = n/2;
        for(Map.Entry<Integer,Integer> mp:map.entrySet()){
            int val = mp.getValue();
            if(val%2!=0){
                return false;
            }
        }
        return true;
    }
}