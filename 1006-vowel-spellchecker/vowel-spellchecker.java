class Solution {
    public boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c)!=-1;
    }
    public String devowel(String word){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i<word.length();i++){
            if(isVowel(word.charAt(i))){
                sb.append("*");
            }
            else{
                sb.append(word.charAt(i));
            }
        }
        return sb.toString().toLowerCase();
    }
    public String[] spellchecker(String[] wordList, String[] queries) {
        HashSet<String> exactWords = new HashSet<String>(Arrays.asList(wordList));
        HashMap<String,String> caseIn = new HashMap<>();
        HashMap<String,String> vowelIn = new HashMap<>();
        int n  = queries.length;
        String[] result = new String[n];
        for(String word:wordList){
            caseIn.putIfAbsent(word.toLowerCase(),word);
            vowelIn.putIfAbsent(devowel(word),word);
        }

        for(int i = 0;i<n;i++){
            String word = queries[i];
            if(exactWords.contains(word)){
                result[i] = word;
            }
            else if(caseIn.containsKey(word.toLowerCase())){
                result[i] = caseIn.get(word.toLowerCase());
            }
            else if(vowelIn.containsKey(devowel(word))){
                result[i] = vowelIn.get(devowel(word));
            }
            else{
                result[i] = "";
            }
    
        }
        return result;
    }
}

