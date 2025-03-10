import java.util.HashMap;

class Solution {
    public long countOfSubstrings(String word, int k) {
        return atLeastK(word, k) - atLeastK(word, k + 1);
    }

    private long atLeastK(String word, int k) {
        long total = 0;
        HashMap<Character, Integer> vmap = new HashMap<>();
        int n = word.length();
        int i = 0, j = 0, conso = 0;

        while (j < n) {
            char c = word.charAt(j);

            if (isVowel(c)) {
                vmap.put(c, vmap.getOrDefault(c, 0) + 1);
            } else {
                conso++;
            }
            while (vmap.size() == 5 && conso >= k) {
                total += n - j;  
                char ci = word.charAt(i);
                if (isVowel(ci)) {
                    vmap.put(ci, vmap.get(ci) - 1);
                    if (vmap.get(ci) == 0) {
                        vmap.remove(ci);
                    }
                } else {
                    conso--;
                }
                i++;
            }

            j++;
        }

        return total;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
