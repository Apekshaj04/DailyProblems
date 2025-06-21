class Solution {
    public int minimumDeletions(String word, int k) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = word.length();
        for(int a:map.values()){
            int deleted = 0;
            for(int b:map.values()){
                if(a>b){
                    deleted+=b;
                }
                else if(b>a+k){
                    deleted+=b-a-k;
                }
            }
            res = Math.min(res,deleted);
        }
        return res;
    }
}
