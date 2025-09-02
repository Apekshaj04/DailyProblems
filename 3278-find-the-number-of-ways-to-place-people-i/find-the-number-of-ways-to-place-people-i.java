class Solution {
    public int numberOfPairs(int[][] points) {
        int ans = 0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            int[] pointA = points[i];
            for (int j = 0; j < n; j++) {
                int[] pointB = points[j];
                if (i == j || !(pointA[0] <= pointB[0] && pointA[1] >= pointB[1])) {
                    continue;
                }
                boolean isInside = false;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    int[] pointC = points[k];
                    if (pointC[0] >= pointA[0] && pointC[0] <= pointB[0] &&
                        pointC[1] >= pointB[1] && pointC[1] <= pointA[1]) {
                        isInside = true;
                        break;
                    }
                }
                if (!isInside) ans++;
            }
        }
        return ans;
    }
}
