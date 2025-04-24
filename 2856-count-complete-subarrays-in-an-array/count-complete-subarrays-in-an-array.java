class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> fullSet = new HashSet<>();
        for(int num : nums){
            fullSet.add(num);
        }
        int l = fullSet.size();
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            Set<Integer> tempSet = new HashSet<>();
            for(int j = i; j < n; j++) {
                tempSet.add(nums[j]);
                if(tempSet.size() == l) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
