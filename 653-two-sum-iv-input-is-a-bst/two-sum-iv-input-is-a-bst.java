class Solution {

    public void preorder(TreeNode root,ArrayList<Integer> res){
        if(root!=null){
            res.add(root.val);
            preorder(root.left,res);
            preorder(root.right,res);

        }
    }
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        preorder(root,res);
        boolean flag = false;
        for(int i = 0 ;i<res.size();i++){
            for(int j = i+1;j<res.size();j++){
                if(res.get(i)+res.get(j)==k){
                    return true;
                }
            }
        }
        return false;
    }
}