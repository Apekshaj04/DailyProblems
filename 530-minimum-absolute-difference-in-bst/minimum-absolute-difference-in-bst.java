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
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    public void  inorderTraversal(TreeNode root){
            if(root==null) return; 
            inorderTraversal(root.left);
            if(prev!=null){
                min = Math.min(min,Math.abs(root.val-prev));
            }
            prev = root.val;
            inorderTraversal(root.right);
    }
        
    
    public int getMinimumDifference(TreeNode root) {
         inorderTraversal(root);
         return min;
    }
}