import java.util.HashMap;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int i = 0, j = 0, n = nums.length;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        long total = 0, sum = 0;

        // Initialize the first windo
        for (j = 0; j < k; j++) {
            freqMap.put(nums[j], freqMap.getOrDefault(nums[j], 0) + 1);
            sum += nums[j];
        }

        if (freqMap.size() == k) {
            total = Math.max(total, sum);
        }

        while (j < n) {
     
            int outElement = nums[i];
            sum -= outElement;
            freqMap.put(outElement, freqMap.get(outElement) - 1);
            if (freqMap.get(outElement) == 0) {
                freqMap.remove(outElement);
            }
            i++;

            int inElement = nums[j];
            sum += inElement;
            freqMap.put(inElement, freqMap.getOrDefault(inElement, 0) + 1);

            if (freqMap.size() == k) {
                total = Math.max(total, sum);
            }

            j++;
        }

        return total;
    }
}
