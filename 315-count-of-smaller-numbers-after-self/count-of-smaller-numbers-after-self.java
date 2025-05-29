class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) set.add(num);
        
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int val : set) {
            map.put(val, idx++);
        }

        int n = map.size();
        int[] seg = new int[4 * n];  
        Integer[] ans = new Integer[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int pos = map.get(nums[i]);
            ans[i] = query(seg, 0, 0, n - 1, 0, pos - 1);  
            update(seg, 0, 0, n - 1, pos);  
        }

        return Arrays.asList(ans);
    }

    public void update(int[] seg, int index, int low, int high, int pos) {
        if (low == high) {
            seg[index]++;
            return;
        }
        int mid = (low + high) / 2;
        if (pos <= mid)
            update(seg, 2 * index + 1, low, mid, pos);
        else
            update(seg, 2 * index + 2, mid + 1, high, pos);
        seg[index] = seg[2 * index + 1] + seg[2 * index + 2]; 
    }

    public int query(int[] seg, int index, int low, int high, int l, int r) {
        if (r < low || l > high) return 0;  
        if (l <= low && r >= high) return seg[index]; 
        int mid = (low + high) / 2;
        return query(seg, 2 * index + 1, low, mid, l, r) +
               query(seg, 2 * index + 2, mid + 1, high, l, r);
    }
}
