class WordFilter {
    class TrieNode{
        TrieNode[] children = new TrieNode[27];
        int index = -1;

    }
    TrieNode root;
    public WordFilter(String[] words) {
        root = new TrieNode();
        for(int i = 0;i<words.length;i++){
            int len = words[i].length();
            String word = words[i];
            for(int j = 0;j<=len;j++){
                String suffix = word.substring(j);
                String key = suffix +"#"+ word;
                insert(key,i);
            }
        }
    }
    public void insert(String k,int index){
        TrieNode curr = root;
        for(char c:k.toCharArray()){
            int idx = (c=='#')?26:c-'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
            curr.index = index;
        }
    }

    
    public int f(String pref, String suff) {
        String searchWord = suff+"#"+pref;
        TrieNode curr = root;
        for(char c:searchWord.toCharArray()){
            int index = (c=='#')?26:c-'a';
            if(curr.children[index]==null){
                return -1;
            }
            curr = curr.children[index];
        }
        return curr.index;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */