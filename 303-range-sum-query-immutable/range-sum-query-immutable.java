class NumArray {
    int[] bit;
    int[] nums;
    int n ;
    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums =  new int[n];
        this.bit = new int[n+1];
        for(int i =0 ;i<n;i++){
            update(i,nums[i]);
        }
    }
    public void update(int i ,int val){
        int diff = val - nums[i];
        nums[i] = val;
        i++;
        while(i<=n){
            bit[i]+=diff;
            i+=i&-i;
        }
    }
    public int getSum(int i){
        int sum = 0;
        i++;
        while(i>0){
            sum+=bit[i]; 
            i -= i &(-i);
        }
        return sum;
    }
    
    public int sumRange(int left, int right) {
        return getSum(right)-getSum(left-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */