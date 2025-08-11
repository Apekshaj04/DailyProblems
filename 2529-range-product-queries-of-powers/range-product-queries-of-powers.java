class Solution {
    static int MOD = 1_000_000_007;

    static class SegmentTree {
        int[] tree;
        int n;
        ArrayList<Integer> arr;

        SegmentTree(int n, ArrayList<Integer> arr) {
            this.n = n;
            this.arr = arr;
            tree = new int[4 * n]; 
            build(0, 0, n - 1);
        }

        public void build(int node, int left, int right) {
            if (left == right) {
                tree[node] = arr.get(left) % MOD;
                return;
            }
            int mid = (left + right) / 2;
            build(2 * node + 1, left, mid);
            build(2 * node + 2, mid + 1, right);
            tree[node] = (int)(((long)tree[2 * node + 1] * tree[2 * node + 2]) % MOD);
        }

        public int query(int node, int tl, int tr, int ql, int qr) {
            if (ql > tr || qr < tl) {
                return 1;
            }
            if (ql <= tl && tr <= qr) {
                return tree[node];
            }
            int mid = (tl + tr) / 2;
            int lr = query(2 * node + 1, tl, mid, ql, qr);
            int rr = query(2 * node + 2, mid + 1, tr, ql, qr);
            return (int)(((long)lr * rr) % MOD);
        }
    }

    public int[] productQueries(int n, int[][] queries) {
        int temp = n;
        int x = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        while (temp > 0) {
            if ((temp & 1) == 1) {
                arr.add(1 << x);
            }
            x++;
            temp = temp >> 1;
        }

        SegmentTree st = new SegmentTree(arr.size(), arr);
        int[] res = new int[queries.length];
        x = 0;

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int rs = st.query(0, 0, arr.size() - 1, l, r);
            res[x++] = rs;
        }

        return res;
    }
}
