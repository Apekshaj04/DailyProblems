import java.util.*;
class Solution {
    public String clearStars(String s) {
        Stack<Map.Entry<Character,Integer>> stack = new Stack<>();
        TreeMap<Character,Deque<Integer>> map = new TreeMap<>();
        int n = s.length();
        boolean[] removed= new boolean[n];
        for(int i = 0;i<n;i++){
            if(s.charAt(i)!='*'){
                stack.push(new AbstractMap.SimpleEntry<>(s.charAt(i),i));
                Deque<Integer> d = map.get(s.charAt(i));
                if(d==null){
                    d = new ArrayDeque<>();
                    map.put(s.charAt(i),d);
                }
                d.addLast(i);
            }
            else{
                    char c = map.firstKey();
                    Deque<Integer> d = map.get(c);
                    int index = d.removeLast();
                    removed[index] = true;
                    if(d.isEmpty()){
                        map.remove(c);
                    }
                }
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> mp:stack){
            if(!removed[mp.getValue()]){

                sb.append(mp.getKey());
            }
        }
        return sb.toString();
    }
}
