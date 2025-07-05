class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> map =new HashMap<>();
        for(int a:arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> mpp:map.entrySet()){
            int key = mpp.getKey();
            int val  = mpp.getValue();
            if(key==val){
                max = Math.max(max,key);
            }
        }
        return (max==Integer.MIN_VALUE)?-1:max;
    }
}