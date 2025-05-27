class NumArray {
    int[] seg;
    int[] nums;
    int n;

    public void build(int index, int low, int high) {
        if (low == high) {
            this.seg[index] = this.nums[low];
            return;
        }
        int mid = (low + high) / 2;
        build(2 * index + 1, low, mid);
        build(2 * index + 2, mid + 1, high);
        this.seg[index] = this.seg[2 * index + 1] + this.seg[2 * index + 2];
    }

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.seg = new int[4 * n];
        build(0, 0, n - 1);
    }

    public void updateSync(int index, int low, int high, int i, int val) {
        if (low == high) {
            this.seg[index] = val;
            return;
        }
        int mid = (low + high) / 2;
        if (i <= mid) {
            updateSync(2 * index + 1, low, mid, i, val);
        } else {
            updateSync(2 * index + 2, mid + 1, high, i, val);
        }
        this.seg[index] = this.seg[2 * index + 1] + this.seg[2 * index + 2];
    }

    public void update(int index, int val) {
        updateSync(0, 0, this.n - 1, index, val);
    }

    public int query(int index, int low, int high, int l, int r) {
        if (l > high || r < low) {
            return 0;
        }
        if (low >= l && high <= r) {
            return this.seg[index];
        }
        int mid = (low + high) / 2;
        int left = query(2 * index + 1, low, mid, l, r);
        int right = query(2 * index + 2, mid + 1, high, l, r);
        return left + right;
    }

    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }
}
