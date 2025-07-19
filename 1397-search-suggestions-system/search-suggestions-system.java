class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean leaf = false;
        int count = 0;
    }

    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.leaf = true;
        }

        public void startsWith(String prefix, List<String> words) {
            TrieNode curr = root;
            StringBuilder sb = new StringBuilder(prefix);
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (curr.children[index] == null) return;
                curr = curr.children[index];
            }
            dfs(curr, sb, words);
        }

        public void dfs(TrieNode curr, StringBuilder sb, List<String> words) {
            if (words.size() == 3) return;

            if (curr.leaf) {
                words.add(sb.toString());
            }

            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    sb.append((char) ('a' + i));
                    dfs(curr.children[i], sb, words);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        Arrays.sort(products);

        for (String product : products) {
            trie.insert(product);
        }

        List<List<String>> result = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < searchWord.length(); i++) {
            prefix.append(searchWord.charAt(i));
            List<String> suggestions = new ArrayList<>();
            trie.startsWith(prefix.toString(), suggestions);
            result.add(suggestions);
        }

        return result;
    }
}
