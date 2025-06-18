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
                int index = c - 'a'; // ✅ corrected
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.flag = true;
        }

        public int longestPrefixLength() {
            TrieNode curr = root;
            int longest = 0;
            while (curr != null && onlyOneIndex(curr) && !curr.flag) {
                int index = findIndex(curr);
                if (index == -1) break;
                curr = curr.children[index];
                longest++;
            }
            return longest;
        }

        public int findIndex(TrieNode curr) {
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    return i;
                }
            }
            return -1;
        }

        public boolean onlyOneIndex(TrieNode curr) {
            int count = 0;
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    count++;
                }
            }
            return count == 1;
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Trie trie = new Trie();
        for (String word : strs) {
            trie.insert(word);
        }

        int len = trie.longestPrefixLength();
        return strs[0].substring(0, len); 
    }
}
