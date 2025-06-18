class WordDictionary {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean flag = false;
    }
    class Trie{
        TrieNode root;
        Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode curr = root;
            for(char c:word.toCharArray()){
                int index = c-'a';
                if(curr.children[index]==null){
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.flag = true;
        }

        public boolean search(String word){
            return dfsSearch(word.toCharArray(),0,root);
        }
      private boolean dfsSearch(char[] word, int pos, TrieNode node) {
            if (node == null) return false;
            if (pos == word.length) return node.flag;

            char c = word[pos];
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (node.children[i] != null && dfsSearch(word, pos + 1, node.children[i])) {
                        return true;
                    }
                }
                return false;
            } else {
                int index = c - 'a';
                return dfsSearch(word, pos + 1, node.children[index]);
            }
        }
    }
    Trie t;
    public WordDictionary() {
        t = new Trie();
    }
    
    public void addWord(String word) {
        t.insert(word);
    }
    
    public boolean search(String word) {
        return t.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */