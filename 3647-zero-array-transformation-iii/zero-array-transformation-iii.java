import java.util.*;

class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        PriorityQueue<Integer> used = new PriorityQueue<>();
        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());

        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));

        int queryPos = 0;
        int applied_cnt = 0;

        for (int i = 0; i < n; i++) {
            while (queryPos < queries.length && queries[queryPos][0] == i) {
                available.offer(queries[queryPos][1]);
                queryPos++;
            }

            nums[i] -= used.size();

            while (nums[i] > 0 && !available.isEmpty() && available.peek() >= i) {
                int t = available.poll();
                used.offer(t);
                nums[i]--;
                applied_cnt++;
            }

            if (nums[i] > 0) {
                return -1;
            }

            while (!used.isEmpty() && used.peek() == i) {
                used.poll();
            }
        }

        return queries.length - applied_cnt;
    }
}
