class Solution {
    static class Pair {
        int no;
        boolean isBack;
        Pair(int no, boolean isBack) {
            this.no = no;
            this.isBack = isBack;
        }
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        HashSet<Integer> set = new HashSet<>();
        for (int f : forbidden) {
            set.add(f);
        }

        if (set.contains(0)) return -1;

        Queue<Pair> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(new Pair(0, false));
        visited.add("0_false");

        int upper = 6000;  // Safe upper bound due to potential overflow
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                if (p.no == x) return steps;

                int forward = p.no + a;
                if (forward <= upper && !set.contains(forward) && !visited.contains(forward + "_false")) {
                    q.offer(new Pair(forward, false));
                    visited.add(forward + "_false");
                }

                int backward = p.no - b;
                if (!p.isBack && backward >= 0 && !set.contains(backward) && !visited.contains(backward + "_true")) {
                    q.offer(new Pair(backward, true));
                    visited.add(backward + "_true");
                }
            }
            steps++;
        }

        return -1;
    }
}
