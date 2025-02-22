import java.util.*;

class Solution {
    public static int minBS(int key, List<Integer> q) {
        int low = 0, high = q.size() - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (q.get(mid) <= key) {
                ans = q.get(mid);  
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans; 
    }

    public static int maxBS(int key, List<Integer> q) {
        int low = 0, high = q.size() - 1, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (q.get(mid) >= key) {
                ans = q.get(mid);  
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans; 
    }

    public void inorder(TreeNode root, List<Integer> arr) {
        if (root == null) return;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> ino = new ArrayList<>();
        inorder(root, ino);  

        for (int query : queries) {
            int x = minBS(query, ino);
            int y = maxBS(query, ino);
            arr.add(Arrays.asList(x, y));
        }
        return arr;
    }
}
