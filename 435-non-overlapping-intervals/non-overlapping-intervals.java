class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int cnt = 0;
        int last = Integer.MIN_VALUE;
        for(int[] i:intervals){
            if(i[0]>=last){
                last = i[1];
            }
            else{
                cnt++;
            }
        }
        return cnt;
    }
}