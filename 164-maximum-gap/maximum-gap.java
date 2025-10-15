class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n<2) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums){
            pq.offer(num);
        }
        int first = pq.poll();
        int last = pq.poll();
        int diff = last-first;
        while(!pq.isEmpty()){
            first = last;
            last = pq.poll();
            diff = Math.max(last-first,diff);
        }
        return diff;
               
    }
}