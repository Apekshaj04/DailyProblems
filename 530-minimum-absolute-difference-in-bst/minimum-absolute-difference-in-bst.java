/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void inorderTraversal(TreeNode root,ArrayList<Integer>arr){
        if(root!=null){
            inorderTraversal(root.left,arr);
            arr.add(root.val);
            inorderTraversal(root.right,arr);
        }
        
    }
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorderTraversal(root,arr);
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<arr.size()-1;i++){
            min = Math.min(min,Math.abs(arr.get(i)-arr.get(i+1)));
        }
        return min;

    }
}