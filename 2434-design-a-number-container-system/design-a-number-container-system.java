class NumberContainers {
    HashMap<Integer,TreeSet<Integer>> map ;
    HashMap<Integer,Integer> in;
    public NumberContainers() {
        map = new HashMap<Integer,TreeSet<Integer>>();
        in = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(in.containsKey(index)){
            int x = in.get(index);
            if(map.containsKey(x)){
                map.get(x).remove(index);
                if(map.get(x).isEmpty()){
                    map.remove(x);
                }
            }
        }
        in.put(index,number);
        map.putIfAbsent(number,new TreeSet<Integer>());
        map.get(number).add(index);
    }
    
    public int find(int number) {
        if(!map.containsKey(number) || map.get(number).isEmpty()){
            return -1;
        }
        return map.get(number).first();
    }

}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */