class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> cmap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int i = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        int j = 0;
        int n = s.length();
        int required = tmap.size();
        int matched = 0;

        while (j < n) {
            char endChar = s.charAt(j);
            cmap.put(endChar, cmap.getOrDefault(endChar, 0) + 1);

            if (tmap.containsKey(endChar) && cmap.get(endChar).intValue() == tmap.get(endChar).intValue()) {
                matched++;
            }

            while (matched == required) {
                if (j - i + 1 < min) {
                    min = j - i + 1;
                    res = s.substring(i, j + 1);
                }

                char startChar = s.charAt(i);
                cmap.put(startChar, cmap.get(startChar) - 1);
                if (cmap.get(startChar) == 0) {
                    cmap.remove(startChar);
                }
                if (tmap.containsKey(startChar) && cmap.getOrDefault(startChar, 0) < tmap.get(startChar)) {
                    matched--;
                }
                i++;
            }
            j++;
        }

        return res;
    }
}
