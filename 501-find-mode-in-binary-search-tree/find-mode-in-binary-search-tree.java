import java.util.*;

class Solution {
    public void preOrder(TreeNode root, HashMap<Integer, Integer> map) {
        if (root != null) {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            preOrder(root.left, map);
            preOrder(root.right, map);
        }
    }

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        HashMap<Integer, Integer> map = new HashMap<>();
        preOrder(root, map);

        int maxFreq = Collections.max(map.values());

        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                modes.add(entry.getKey());
            }
        }

        return modes.stream().mapToInt(i -> i).toArray();
    }
}
