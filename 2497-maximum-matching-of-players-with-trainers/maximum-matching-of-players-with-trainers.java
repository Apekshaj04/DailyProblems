class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.sort(players);
        Arrays.sort(trainers);
        int cnt = 0;
        int n = players.length;
        int m = trainers.length;
        int j = 0;
        for(int i = 0;i<n;i++){
            while(j<m && players[i]>trainers[j]){
                j++;
            }
            if(j==m) return cnt;
            if(players[i]<=trainers[j]){
                cnt++;
                j++;
            }

        }
        return cnt;
    }
}