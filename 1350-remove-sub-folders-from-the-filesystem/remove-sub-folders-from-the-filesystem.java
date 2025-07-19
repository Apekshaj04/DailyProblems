class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[27];
        boolean flag = false;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public void insert(String s) {
            TrieNode curr = root;
            for (int i = 0; i < s.length(); i++) {
                char a = s.charAt(i);
                int index = (a == '/') ? 26 : a - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.flag = true;
        }

        public boolean search(String word) {
            TrieNode curr = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char a = word.charAt(i);
                int index = (a == '/') ? 26 : a - 'a';

                if (curr.children[index] == null) {
                    return false;
                }

                curr = curr.children[index];

                
                if (curr.flag && (i + 1 == n || word.charAt(i + 1) == '/')) {
                    return true;
                }
            }
            return false;
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        Trie trie = new Trie();

        for (String path : folder) {
            if (!trie.search(path)) {
                trie.insert(path);
                res.add(path);
            }
        }

        return res;
    }
}
