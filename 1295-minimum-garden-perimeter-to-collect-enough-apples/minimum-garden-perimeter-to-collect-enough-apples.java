class Solution {
    public boolean canGet(long half, long neededApples) {
      
        long result = 2L * half * (half + 1) * (2 * half + 1);
        return result >= neededApples;
    }

    public long minimumPerimeter(long neededApples) {
        long low  = 1;
        long high = (long) 1e5; // safe upper bound
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canGet(mid, neededApples)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 8L * ans;
    }
}
