class NumArray {
    int[] nums;
    int[] seg;
    int n;
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.seg = new int[4*n];
        build(0,0,n-1);
    }
    public void build(int index,int left,int right){
        if(left==right){
            this.seg[index] = this.nums[left];
            return ; 
        }
        int mid = left + (right-left)/2;
        build(2*index+1,left,mid);
        build(2*index+2,mid+1,right);
        this.seg[index] = this.seg[2*index+1] + seg[2*index+2];
    }
    public int query(int index,int low,int high,int l,int r){
        if(low>= l && r>=high){
            return this.seg[index];
        }
        if(high<l || low>r){
            return 0;
        }
        int mid = low+(high-low)/2;
        int left = query(2*index+1,low,mid,l,r);
        int right = query(2*index+2,mid+1,high,l,r);
        return left+right;
        
    }
    
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */