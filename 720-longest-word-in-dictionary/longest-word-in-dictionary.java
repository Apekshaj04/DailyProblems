class Solution {
    public String longestWord(String[] words) {
        Set<String> wordSet = new HashSet<>();
        Arrays.sort(words);
        int n = words.length;
        wordSet.add("");
        int max = 0;
        String result = "";
        for(String word:words){
            if(wordSet.contains(word.substring(0,word.length()-1))){
                wordSet.add(word);
                if(word.length()>max){
                    max = word.length();
                    result = word;
                }
            }
        }
        return result;
    }
}