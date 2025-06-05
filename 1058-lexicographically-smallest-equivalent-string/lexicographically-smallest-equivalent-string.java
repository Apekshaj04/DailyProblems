class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        char[] parent = new char[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = (char) (i + 'a');
        }

        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            char pa = findParent(a, parent);
            char pb = findParent(b, parent);

            if (pa == pb) continue;

            if (pa < pb) {
                parent[pb - 'a'] = pa;
            } else {
                parent[pa - 'a'] = pb;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            sb.append(findParent(c, parent));
        }

        return sb.toString();
    }

    private char findParent(char c, char[] parent) {
        while (parent[c - 'a'] != c) {
            c = parent[c - 'a'];
        }
        return c;
    }
}
