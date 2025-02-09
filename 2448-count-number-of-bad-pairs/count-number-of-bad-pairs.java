class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long total = (n-1)*n/2;
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        long good = 0 ;
        while(i<n){
            if(map.containsKey(nums[i]-i)){
                good += map.get(nums[i]-i);
            }
            map.put(nums[i]-i,map.getOrDefault(nums[i]-i,0)+1);
            i++;
        }
        return total - good;
    }
}