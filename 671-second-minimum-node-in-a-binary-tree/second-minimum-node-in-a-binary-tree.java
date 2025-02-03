class Solution {
    long first = Long.MAX_VALUE;
    long second = Long.MAX_VALUE;
    

    public void findSecondMinimum(TreeNode root) {
        if (root != null) {
            if (root.val < first) {
                second = first;
                first = root.val;
            } else if (root.val > first && root.val < second) {
                second = root.val;
            }
            findSecondMinimum(root.left);
            findSecondMinimum(root.right);
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        
        first = root.val;  

        findSecondMinimum(root);

        return (second < Long.MAX_VALUE) ? (int)second : -1;
    }
}
