class Solution {
    public String[] findWords(String[] words) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('q',1);
        map.put('w',1);
        map.put('e',1);
        map.put('r',1);
        map.put('t',1);
        map.put('y',1);
        map.put('u',1);
        map.put('i',1);
        map.put('o',1);
        map.put('p',1);

        map.put('a',2);
        map.put('s',2);
        map.put('d',2);
        map.put('f',2);
        map.put('g',2);
        map.put('h',2);
        map.put('j',2);
        map.put('k',2);
        map.put('l',2);

        map.put('z',3);
        map.put('x',3);
        map.put('c',3);
        map.put('v',3);
        map.put('b',3);
        map.put('n',3);
        map.put('m',3);
        int n = words.length;
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0 ;i<n;i++){
            String word = words[i];
            int m  = word.length();
            if(m<=0){
                continue;
            }
            int prev =  map.get(Character.toLowerCase(word.charAt(0)));
            int j = 1;
            for( j=1;j<m;j++){
                if(map.get(Character.toLowerCase(word.charAt(j)))!=prev){
                    break;
                }
            }
            if(j==m){
                res.add(word);
            }
        }
        String[] result = new String[res.size()];
        for(int i = 0;i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
        
    }
}