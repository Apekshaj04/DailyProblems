class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        if(basket1.length!=basket2.length) return -1;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int b:basket1){
            map.put(b,map.getOrDefault(b,0)+1);
        }
        for(int b:basket2){
            map.put(b,map.getOrDefault(b,0)-1);
        }
        int minVal = Integer.MAX_VALUE;
        for(int b:basket1){
            minVal = Math.min(minVal,b);
        }
        for(int b:basket2){
            minVal = Math.min(minVal,b);
        }
        long res= 0 ;
        ArrayList<Integer> swap = new ArrayList<>();
        for(int key:map.keySet()){
            int count = map.get(key);
            if(count%2!=0){
                return -1;
            }
            for(int i = 0;i<Math.abs(count)/2;i++){
                swap.add(key);
            }
        }
        Collections.sort(swap);
        for(int i = 0;i<swap.size()/2;i++){
            res += Math.min(minVal*2,swap.get(i));
        }
        return res;

    }
}