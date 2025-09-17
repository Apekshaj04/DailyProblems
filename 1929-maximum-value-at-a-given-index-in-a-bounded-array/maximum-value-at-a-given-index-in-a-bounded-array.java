class Solution {
    private long sum(long big, int length) {
        if (big >= length) {
            return (big + (big - length + 1)) * length / 2;
        } else {
            return (big + 1) * big / 2 + (length - big);
        }
    }

    private boolean canDivide(int index, int n, int mid, int maxSum) {
        long left = sum(mid - 1, index);
        long right = sum(mid - 1, n - index - 1);
        long total = left + right + mid;
        return total <= maxSum;
    }

    public int maxValue(int n, int index, int maxSum) {
        int low = 1, high = maxSum, ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canDivide(index, n, mid, maxSum)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
