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
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0 ;
        }
      
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        
    }
    public TreeNode bfs(TreeNode root,int depth){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root!=null){
            queue.offer(root);
        }
        int cd = 0;
        List<TreeNode> lastLevel = new ArrayList<TreeNode>();
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<TreeNode> thisLevel = new ArrayList<TreeNode>();
            for(int i = 0;i<levelSize;i++){
                TreeNode temp = queue.poll();
                thisLevel.add(temp);
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            cd++;
            if(cd==depth){
                lastLevel = thisLevel;
                break;
            }

        }
        return findLCA(root,new HashSet<>(lastLevel));
    }
    public TreeNode findLCA(TreeNode root,Set<TreeNode> nodes){
        if(root==null || nodes.contains(root)){
            return root;
        }
        TreeNode left = findLCA(root.left,nodes);
        TreeNode right = findLCA(root.right,nodes);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int depth = maxDepth(root);
        // System.out.println(depth);
        if(depth==1){
            return root;
        }
        return bfs(root,depth);
    }
}