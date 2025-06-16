class LUPrefix {
    int n ;
    boolean[] visited;
    int prefix;
    public LUPrefix(int n) {
        this.n = n;
        prefix = 0;
        visited = new boolean[n+2];
        Arrays.fill(visited,false);
    }
    
    public void upload(int video) {
        visited[video] = true;
    }
    
    public int longest() {
        while(visited[prefix+1]==true){
            prefix++;
        }
        return prefix;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */