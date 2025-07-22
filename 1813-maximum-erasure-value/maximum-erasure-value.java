class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int msum = 0;
        int i = 0, j =0 ;
        int n = nums.length;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(j<n){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            sum+=nums[j];
            while(i<n && map.size()!=j-i+1){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0){
                    map.remove(nums[i]);
                }
                sum-=nums[i];
                i++;
            }
            msum = Math.max(msum,sum);
            j++;
        }
        return msum;
    }
}