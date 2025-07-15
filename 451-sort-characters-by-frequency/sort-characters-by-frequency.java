class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Map.Entry<Character,Integer>> list =  new ArrayList<>(map.entrySet());
        list.sort((a,b)->{
            if(!a.getValue().equals(b.getValue())){
                return b.getValue().compareTo(a.getValue());
            }
            return Character.compare(a.getKey(),b.getKey());
        }
        );
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer>entry:list){
            sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        return sb.toString();
    }
}