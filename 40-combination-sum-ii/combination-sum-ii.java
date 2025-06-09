class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        backtrack(result, 0, target, candidates, new ArrayList<>(), visited);
        return result;
    }

    public void backtrack(List<List<Integer>> result, int index, int target, int[] nums, List<Integer> temp, boolean[] visited) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;

            if (nums[i] > target) break;

            temp.add(nums[i]);
            visited[i] = true;
            backtrack(result, i + 1, target - nums[i], nums, temp, visited);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
