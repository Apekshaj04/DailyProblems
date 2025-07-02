class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        if(deads.contains("0000")){
            return -1;
        }
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0;j<size;j++){
                String current = q.poll();
                if(deads.contains(current)){
                    continue;
                }
                if(current.equals(target)){
                    return level;
                }
                for(int i = 0;i<4;i++){
                    char[] chars = current.toCharArray();
                    chars[i] = (chars[i]=='9')?'0':(char)(chars[i]+1);
                    String word = new String(chars);
                    if(!visited.contains(word) && !deads.contains(word)){
                        visited.add(word);
                        q.add(word);
                    }
                    chars[i] = current.charAt(i);
                    chars[i] = (chars[i]=='0')?'9':(char)(chars[i]-1);
                    String w = new String(chars);
                    if(!visited.contains(w) && !deads.contains(w)){
                        visited.add(w);
                        q.add(w);
                    }
                    
                }
            }
            level++;
        }
        return -1;
    }
}