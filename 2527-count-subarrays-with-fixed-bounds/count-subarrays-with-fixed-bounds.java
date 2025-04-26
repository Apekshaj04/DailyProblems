class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int minIndex = -1;
        int maxIndex = -1;
        int badIndex = -1;
        long cnt = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (minK <= nums[i] && nums[i] <= maxK) {
                if (nums[i] == minK) {
                    min = nums[i];
                    minIndex = i;
                }
                if (nums[i] == maxK) {
                    max = nums[i];
                    maxIndex = i;
                }
            } else {
                badIndex = i;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                minIndex = -1;
                maxIndex = -1;
            }

            int validStart = Math.min(minIndex, maxIndex);
            if (validStart > badIndex) {
                cnt += validStart - badIndex;
            }
        }

        return cnt;
    }
}
