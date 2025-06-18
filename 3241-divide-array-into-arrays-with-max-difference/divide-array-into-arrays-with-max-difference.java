class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);

        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            int current = nums[i];
            if (map.getOrDefault(current, 0) == 0) continue;

            ArrayList<Integer> temp = new ArrayList<>();

            for (int j = current; j <= current + k; j++) {
                while (map.getOrDefault(j, 0) > 0 && temp.size() < 3) {
                    temp.add(j);
                    map.put(j, map.get(j) - 1);
                }
                if (temp.size() == 3) break;
            }

            if (temp.size() != 3) return new int[0][0]; 
            arr.add(temp);
        }

        int[][] result = new int[arr.size()][3];
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = arr.get(i).get(j);
            }
        }

        return result;
    }
}
