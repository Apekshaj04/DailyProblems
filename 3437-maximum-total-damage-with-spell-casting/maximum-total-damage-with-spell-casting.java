class Solution {
    public long maximumTotalDamage(int[] power) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int p : power) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        ArrayList<Integer> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr);
        int n = arr.size();

        long[] dp = new long[n];
        dp[0] = (long) arr.get(0) * map.get(arr.get(0));

        for (int i = 1; i < n; i++) {
            int curr = arr.get(i);
            long total = (long) curr * map.get(curr);

            int j = i - 1;
            while (j >= 0 && arr.get(j) >= curr - 2) {
                j--;
            }

            long include = total + (j >= 0 ? dp[j] : 0);
            long exclude = dp[i - 1];

            dp[i] = Math.max(include, exclude);
        }

        return dp[n - 1];
    }
}
