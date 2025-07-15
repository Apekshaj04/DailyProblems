class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int maxLen = 0;
        int n = s.length();

        while (j < n) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                map.put(c, map.getOrDefault(c, 0) + 1);
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else {
                char leftChar = s.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                    set.remove(leftChar);
                }
                i++;
            }
        }

        return maxLen;
    }
}
