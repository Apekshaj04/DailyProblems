class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i<n;i++){
            char curr = s.charAt(i);
            map.put(curr,map.get(curr)-1);
            if(set.contains(curr)) continue;
            while(sb.length()>0 && sb.charAt(sb.length()-1)>curr && map.get(sb.charAt(sb.length()-1))>0){
                set.remove(sb.charAt(sb.length()-1));
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(curr);
            set.add(curr);
        }
        return sb.toString();

    }
}