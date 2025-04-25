class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.size();
        int prefixCount = 0;
        long interesting =0;
        int pos = 0;
        map.put(0,1);
        while(pos<n){
            if(nums.get(pos)%modulo==k){
                prefixCount++;
            }
            prefixCount = prefixCount%modulo;
            int term = (prefixCount-k+modulo)%modulo;
            if(map.containsKey(term)){
                interesting += map.get(term);
               
            }
            map.put(prefixCount,map.getOrDefault(prefixCount,0)+1);
            pos++;
        }
        return interesting;
    }
}