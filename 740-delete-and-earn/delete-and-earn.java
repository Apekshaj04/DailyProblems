class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr);

        int n = arr.size();
        int[] dp = new int[n + 1];

        dp[0] = arr.get(0) * map.get(arr.get(0));

        for (int i = 1; i < n; i++) {
            int curr = arr.get(i);
            int currPoints = curr * map.get(curr);

            if (curr == arr.get(i - 1) + 1) {
                dp[i] = Math.max(dp[i - 1], (i >= 2 ? dp[i - 2] : 0) + currPoints);
            } else {
                dp[i] = dp[i - 1] + currPoints;
            }
        }

        return dp[n - 1];
    }
}
