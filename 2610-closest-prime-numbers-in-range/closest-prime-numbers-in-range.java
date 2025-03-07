import java.util.ArrayList;

class Solution {
    public int prime(int n) {
        if (n <= 1) {
            return 0; // Not a prime number
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return 0; // Not a prime number
            }
        }
        return 1; // Prime number
    }

    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        // Collect prime numbers in range
        for (int i = left; i <= right; i++) {
            if (prime(i) == 1) {
                arr.add(i);
            }
        }
        
        // If fewer than 2 prime numbers are found, return [-1, -1]
        if (arr.size() < 2) {
            return new int[]{-1, -1};
        }

        // Find closest prime pair
        int minDiff = Integer.MAX_VALUE;
        int[] res = new int[2];

        for (int i = 1; i < arr.size(); i++) {
            int diff = arr.get(i) - arr.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                res[0] = arr.get(i - 1);
                res[1] = arr.get(i);
            }
        }

        return res;
    }
}
