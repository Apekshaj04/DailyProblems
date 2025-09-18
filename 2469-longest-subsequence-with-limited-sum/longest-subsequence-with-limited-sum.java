import java.util.*;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int m = queries.length;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int q = queries[i];
            int idx = upperBound(prefix, q);
            result[i] = idx;
        }
        return result;
    }

    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans + 1;
    }
}
