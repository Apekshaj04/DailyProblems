class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean flag = false;
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.flag = true;
        }

        public String searchPrefix(String word) {
            TrieNode curr = root;
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    return word;
                }
                sb.append(c);
                curr = curr.children[index];
                if (curr.flag) {
                    return sb.toString(); 
                }
            }
            return word; 
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie t = new Trie();
        for (String word : dictionary) {
            t.insert(word);
        }

        String[] words = sentence.trim().split("\\s+"); // ✅ fixed regex
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(t.searchPrefix(word)).append(" ");
        }

        return sb.toString().trim();
    }
}
