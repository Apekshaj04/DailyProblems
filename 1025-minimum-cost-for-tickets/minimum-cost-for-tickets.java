import java.util.*;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> travelDays = new HashSet<>();
        int lastDay = 0;

        for (int day : days) {
            travelDays.add(day);
            lastDay = Math.max(lastDay, day);
        }

        int[] dp = new int[lastDay + 1];

        for (int i = 1; i <= lastDay; i++) {
            if (!travelDays.contains(i)) {
                dp[i] = dp[i - 1];
            } else {
                int cost1 = dp[i - 1] + costs[0];
                int cost7 = dp[Math.max(0, i - 7)] + costs[1];
                int cost30 = dp[Math.max(0, i - 30)] + costs[2];
                dp[i] = Math.min(cost1, Math.min(cost7, cost30));
            }
        }

        return dp[lastDay]; // ✅ corrected
    }
}
