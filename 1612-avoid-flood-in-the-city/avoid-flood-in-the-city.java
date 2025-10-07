import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        Set<Integer> fullLakes = new HashSet<>();
        PriorityQueue<Lake> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.nextRainDay));

        for (int i = 0; i < n; i++) {
            if (rains[i] != 0) {
                map.computeIfAbsent(rains[i], k -> new LinkedList<>()).offer(i);
            }
        }

        for (int i = 0; i < n; i++) {
            int lake = rains[i];

            if (lake != 0) {
                result[i] = -1;
                Queue<Integer> q = map.get(lake);
                q.poll(); 
                if (fullLakes.contains(lake)) {
                    return new int[0]; 
                }

                fullLakes.add(lake);

                if (!q.isEmpty()) {
                    pq.offer(new Lake(lake, q.peek()));
                }

            } else {
                if (!pq.isEmpty()) {
                    Lake next = pq.poll();

                    result[i] = next.id;
                    fullLakes.remove(next.id); 
                } else {
                    result[i] = 1;
                }
            }
        }

        return result;
    }

    static class Lake {
        int id;
        int nextRainDay;

        Lake(int id, int nextRainDay) {
            this.id = id;
            this.nextRainDay = nextRainDay;
        }
    }
}
