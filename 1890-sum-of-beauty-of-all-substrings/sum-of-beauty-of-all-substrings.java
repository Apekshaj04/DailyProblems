class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26]; 

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                if (j - i + 1 >= 2) { 
                    int most = 0, least = Integer.MAX_VALUE;

                    for (int f : freq) {
                        if (f > 0) {
                            most = Math.max(most, f);
                            least = Math.min(least, f);
                        }
                    }
                    sum += most - least;
                }
            }
        }
        return sum;
    }
}
