class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();

        int n = words.length;

        for (int i = 0; i < n; i++) {
            String word = words[i];
            int weight = 0;

            for (char c : word.toCharArray()) {
                int index = c - 'a';
                weight += weights[index];
            }

            int modulo = weight % 26;
            char mappedChar = (char) (122 - modulo);

            sb.append(mappedChar);
        }

        return sb.toString();
    }
}