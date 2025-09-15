class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character>set = new HashSet<>();
        for(char c:brokenLetters.toCharArray()){
            set.add(c);
        }
        String[] arr = text.trim().split("\\s+");
        int n= arr.length;
        int total = 0;
        for(int i =0;i<n;i++){
            String word = arr[i];
            for(int j = 0;j<word.length();j++){
                if(set.contains(word.charAt(j))){
                    total++;
                    break;
                }
            }
        }
        return n-total;
    }
}