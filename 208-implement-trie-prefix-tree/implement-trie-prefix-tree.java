class TrieNode{
    TrieNode[] children  = new TrieNode[26];
    boolean flag = false;
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
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
    public TrieNode searchNode(String word){
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            int index = c-'a';
            if(curr.children[index]==null) return null;
            curr = curr.children[index];
        }
        return curr;
    }
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node!=null && node.flag;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix);
        return node!=null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */