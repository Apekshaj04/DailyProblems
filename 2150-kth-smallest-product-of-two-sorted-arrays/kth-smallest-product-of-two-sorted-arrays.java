class Solution {
    public boolean countLessOrEqual(int[] nums1, int[] nums2, long target, long k) {
        long count = 0;
        int m = nums2.length;

        for (int x : nums1) {
            if (x > 0) {
                int low = 0, high = m - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if ((long) x * nums2[mid] <= target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                count += low;
            } else if (x < 0) {
                int low = 0, high = m - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if ((long) x * nums2[mid] <= target) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                count += (m - low);
            } else { // x == 0
                if (target >= 0) {
                    count += m;
                }
            }
        }

        return count >= k;
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -10000000000L;  // -1e10
        long high = 10000000000L;  // 1e10

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (countLessOrEqual(nums1, nums2, mid, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
