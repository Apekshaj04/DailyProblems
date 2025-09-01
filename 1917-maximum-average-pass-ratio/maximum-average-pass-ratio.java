import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(b[2], a[2]));

        for(int[] c : classes) {
            double pass = c[0], total = c[1];
            maxHeap.offer(new double[]{pass, total, (pass+1)/(total+1) - pass/total});
        }

        while(extraStudents-- > 0) {
            double[] top = maxHeap.poll();
            top[0] += 1;
            top[1] += 1;
            top[2] = (top[0]+1)/ (top[1]+1) - top[0]/top[1];
            maxHeap.offer(top);
        }

        double avg = 0;
        int n = classes.length;
        while(!maxHeap.isEmpty()) {
            double[] c = maxHeap.poll();
            avg += c[0]/c[1];
        }

        return avg/n;
    }
}
