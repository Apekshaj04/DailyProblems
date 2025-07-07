class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        int n = events.length;
        int day = 0;
        int count = 0 ;
        while(i<n || !pq.isEmpty()){
            if(pq.isEmpty()){
                day = events[i][0];
            }
            while(i<n && events[i][0]<=day){
                pq.offer(events[i][1]);
                i++;
            }
            pq.poll();
            count++;
            day++;
            while(!pq.isEmpty() && pq.peek()<day){
                pq.poll();
            }
        }
        return count;
        
    }
}