class Solution {
    public String smallestPalindrome(String s) {
        Map<Character, Integer> map = new TreeMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder firstHalf = new StringBuilder();
        char middle = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int freq = entry.getValue();

            for (int i = 0; i < freq / 2; i++) {
                firstHalf.append(c);
            }

            if (freq % 2 == 1) {
                middle = c;
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(firstHalf);

        if (middle != 0) {
            ans.append(middle);
        }

        ans.append(new StringBuilder(firstHalf).reverse());

        return ans.toString();
    }
}