class Solution {
    public int findLHS(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int longest = 0 ;
        for(Map.Entry<Integer,Integer>mpp:map.entrySet()){
            int key = mpp.getKey();
            int val = mpp.getValue();
            if(map.containsKey(key+1)){
                int next = map.get(key+1);
                longest = Math.max(longest,val+next);
            }
        }
        return longest;
    }
}