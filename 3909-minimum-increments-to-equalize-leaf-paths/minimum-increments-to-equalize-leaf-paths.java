import java.util.*;

public class Solution {
    private int updatesNeeded = 0;

    private long traverse(int current, int parent, List<List<Integer>> graph, int[] nodeCost) {
        long maxChildPath = 0;
        long[] childSums = new long[graph.get(current).size()];
        int index = 0;

        for (int neighbor : graph.get(current)) {
            if (neighbor == parent) continue;
            long pathSum = traverse(neighbor, current, graph, nodeCost);
            childSums[index++] = pathSum;
            maxChildPath =Math.max(maxChildPath, pathSum);
        }

        for (int i = 0; i < index; i++) {
            if (childSums[i] < maxChildPath) {
                updatesNeeded++;
            }
        }

        return nodeCost[current] + maxChildPath;
    }

    public int minIncrease(int n, int[][] edges, int[] cost) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] link : edges) {
            int a = link[0], b = link[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        traverse(0, -1, graph, cost);
        return updatesNeeded;
    }
}
