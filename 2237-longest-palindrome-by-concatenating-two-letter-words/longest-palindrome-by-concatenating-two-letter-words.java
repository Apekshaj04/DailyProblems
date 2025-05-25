class Solution {
    public boolean isPallindrome(String word){
        int n = word.length();
        for(int i = 0; i < n / 2; i++){
            if(word.charAt(i) != word.charAt(n - i - 1)){
                return false;
            }
        }
        return true;
    }

    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int totalLength = 0;
        boolean centerUsed = false;

        for(String word : map.keySet()){
            String reversed = new StringBuilder(word).reverse().toString();

            if(word.equals(reversed)){
                int freq = map.get(word);
                totalLength += (freq / 2) * 4;
                if(freq % 2 == 1) centerUsed = true;
            } else if(map.containsKey(reversed)) {
                int freq1 = map.get(word);
                int freq2 = map.get(reversed);
                int pairs = Math.min(freq1, freq2);
                totalLength += pairs * 4;
                map.put(word, freq1 - pairs);
                map.put(reversed, freq2 - pairs);
            }
        }

        if(centerUsed) totalLength += 2; 

        return totalLength;
    }
}
