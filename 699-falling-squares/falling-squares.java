class Solution {
    static final int N = 100002;
    int INF = (int)1e9;
    int[] tree = new int[4 * N];
    int[] lazy = new int[4 * N];
    void push(int node) {
        if (lazy[node] != -1) {
            tree[2 * node + 1] = tree[2 * node + 2] = lazy[node];
            lazy[2 * node + 1] = lazy[2 * node + 2] = lazy[node];
            lazy[node] = -1;
        }
    }

    void update(int node, int tl, int tr, int l, int r, int updatedVal) {
        if (tl > tr || tr < l || r < tl) return;

        if (l <= tl && tr <= r) {
            tree[node] = updatedVal;
            lazy[node] = updatedVal;
        } else {
            push(node);
            int tm = (tl + tr) / 2;
            update(2 * node + 1, tl, tm, l, r, updatedVal);        // Left child
            update(2 * node + 2, tm + 1, tr, l, r, updatedVal);    // Right child
            tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
        }
    }

    // Query function with lazy propagation
    int query(int node, int tl, int tr, int l, int r) {
        if (tl > tr || tr < l || r < tl) return -INF;

        if (l <= tl && tr <= r) {
            return tree[node];
        }

        push(node);
        int tm = (tl + tr) / 2;
        int q1 = query(2 * node + 1, tl, tm, l, r);        
        int q2 = query(2 * node + 2, tm + 1, tr, l, r);    
        return Math.max(q1, q2);
    }

    public List<Integer> fallingSquares(int[][] positions) {
        Arrays.fill(tree, 0);
        Arrays.fill(lazy, -1);

        TreeSet<Integer> coords = new TreeSet<>();
        for (int[] pos : positions) {
            coords.add(pos[0]);
            coords.add(pos[0] + pos[1] - 1);
        }

        Map<Integer, Integer> index = new HashMap<>();
        int compressedIdx = 1;
        for (int coord : coords) {
            index.put(coord, compressedIdx++);
        }

        int n = compressedIdx;
        int best = 0;
        List<Integer> ans = new ArrayList<>();

        for (int[] pos : positions) {
            int l = index.get(pos[0]);
            int r = index.get(pos[0] + pos[1] - 1);
            int maxHeight = query(0, 1, n, l, r);
            update(0, 1, n, l, r, maxHeight + pos[1]);
            best = Math.max(best, query(0, 1, n, 1, n));
            ans.add(best);
        }

        return ans;
    }
}
