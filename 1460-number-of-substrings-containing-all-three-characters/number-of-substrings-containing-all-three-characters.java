class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int res = 0;
        int n = s.length();

        for (int j = 0; j < n; j++) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            while (map.size() == 3) {
                res += (n - j);
                char leftChar = s.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                i++;
            }
        }

        return res;
    }
}