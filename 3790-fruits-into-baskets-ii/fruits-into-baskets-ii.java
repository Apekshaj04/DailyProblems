class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int m = baskets.length;
        int count =0;
        boolean[] visited = new boolean[m];
        Arrays.fill(visited,false);
        for(int i = 0 ;i<n;i++){
            int f = fruits[i];
            for(int j = 0;j<m;j++){
                if(baskets[j]>=f && !visited[j]){
                    visited[j] = true;
                    break;
                }
            }

        }
        for(int i = 0;i<m;i++){
            if(!visited[i]){
                count++;
            }
        }
        return count;
    }
}