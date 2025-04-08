class Solution {
    public int minimumOperations(int[] nums) {
        int op = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);

        while (true) {
            Set<Integer> set = new HashSet<>(list);
            if (set.size() == list.size()) break; 
            int removeCount = Math.min(3, list.size());
            for (int i = 0; i < removeCount; i++) {
                list.remove(0); 
            }
            op++;
        }
        return op;
    }
}
