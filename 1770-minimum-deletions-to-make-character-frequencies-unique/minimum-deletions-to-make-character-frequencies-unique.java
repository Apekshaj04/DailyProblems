class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int ops = 0;
        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Character,Integer> mpp:map.entrySet()){
            int val = mpp.getValue();
            System.out.println(mpp.getKey()+" "+val);
            if(set.contains(val)){
                while(set.contains(val) && val>=0){
                    val--;
                    ops++;
                }
                if(val>0){
                    set.add(val);

                }
            }
            else{
                set.add(val);
            }

        }
        return ops;
    }
}