class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            map.putIfAbsent(val, new ArrayList<>());
            map.get(val).add(i);
        }

        int miniDist = Integer.MAX_VALUE;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ArrayList<Integer> list = entry.getValue();
            int m = list.size();

            if (m >= 3) {
                for (int i = 0; i <= m - 3; i++) {
                    int i1 = list.get(i);
                    int i2 = list.get(i + 1);
                    int i3 = list.get(i + 2);

                    int dist = Math.abs(i1 - i2) 
                             + Math.abs(i2 - i3) 
                             + Math.abs(i3 - i1);

                    miniDist = Math.min(miniDist, dist);
                }
            }
        }

        return miniDist == Integer.MAX_VALUE ? -1 : miniDist;
    }
}