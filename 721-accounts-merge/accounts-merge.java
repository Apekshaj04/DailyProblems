class Solution {
    static class DSU{
        int[] parent;
        int[] size;
        public DSU(int n ){
            parent = new int[n];
            size = new int[n];
            for(int i = 0;i<n;i++){
                parent[i] = i ;
                size[i] = 1;
            }
        }
        public void union(int u,int v){
            int pu = findParent(u);
            int pv = findParent(v);
            if(pu==pv) return ;
            if(size[pu]<size[pv]){
                parent[pu] = pv;
                size[pv]+=size[pu];
            }
            else{
                parent[pv] = pu ; 
                size[pv] +=size[pu];
            }
        }
        public int findParent(int u){
            if(parent[u]==u) return u ;
            return parent[u] = findParent(parent[u]);
        }

    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            for(int j = 1;j<accounts.get(i).size();j++){
                String email = accounts.get(i).get(j);
                if(!map.containsKey(email)){
                    map.put(email,i);
                }
                else{
                    dsu.union(i,map.get(email));
                }
            }
        }
        List<String>[] mails = new ArrayList[n];
        for(int i = 0;i<n;i++){
            mails[i] = new ArrayList<>();
        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            int index=  dsu.findParent(entry.getValue());
            mails[index].add(entry.getKey());
        }
        List<List<String>> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(mails[i].size() == 0) 
                continue;
            Collections.sort(mails[i]);
            List<String> ls = new ArrayList<>();
            ls.add(accounts.get(i).get(0));
            for(String m : mails[i]) {
                ls.add(m);
            }
            list.add(ls);
        }

        return list;
    }
}