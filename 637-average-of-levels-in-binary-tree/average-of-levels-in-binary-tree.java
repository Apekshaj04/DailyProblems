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
    public List<Double> levelOrder(TreeNode root){
        if(root==null ) return new ArrayList<Double>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Double> res = new ArrayList<Double>();
        
        while(!q.isEmpty()){
            int size = q.size();
            double x= 0 ;
            for(int i = 0;i<size;i++){
                TreeNode temp = q.poll();
                x+=temp.val;
                if(temp.left!=null){
                   q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }

            }
            res.add(x/size);
            
        }
        return res;

    }
    public List<Double> averageOfLevels(TreeNode root) {
        return levelOrder(root);
    }
}