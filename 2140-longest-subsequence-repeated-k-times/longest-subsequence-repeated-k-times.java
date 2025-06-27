import java.util.*;

class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        ArrayList<Character> candidate = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] >= k) {
                candidate.add((char) ('a' + i));
            }
        }

        Queue<String> q = new LinkedList<>();
        for (char c : candidate) {
            q.offer(String.valueOf(c));
        }

        String ans = "";
        while (!q.isEmpty()) {
            String curr = q.poll();

            if (curr.length() > ans.length() || 
               (curr.length() == ans.length() && curr.compareTo(ans) > 0)) {
                ans = curr;
            }

            for (char c : candidate) {
                String next = curr + c;
                if (isRepeated(s, next, k)) {
                    q.offer(next);
                }
            }
        }

        return ans;
    }

    public boolean isRepeated(String s, String t, int k) {
        int count = 0;
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
                if (j == t.length()) {
                    count++;
                    j = 0;
                    if (count == k) return true;
                }
            }
        }

        return false;
    }
}
