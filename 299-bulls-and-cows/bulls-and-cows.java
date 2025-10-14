class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0 ,cows = 0;
        int n = secret.length();
        Set<Integer> indices = new HashSet<>();
        // counting bulls 
        for(int i = 0;i<n;i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s==g){
                bulls++;
                indices.add(i);
            }
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            if(!indices.contains(i)){
                char c = secret.charAt(i);
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }
        for(int i = 0;i<n;i++){
            if(!indices.contains(i)){
                char  c = guess.charAt(i);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)-1);
                    cows++;
                    if(map.get(c)==0){
                        map.remove(c);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        return sb.toString();
        
    }
}