class Solution {
    static class Pair{
        char letter;
        int freq;
        Pair(char letter,int freq){
            this.letter = letter;
            this.freq = freq;
        }
    }
    public boolean isVowel(char a){
        if(a=='a' || a=='e' || a=='i' || a=='o' || a=='u'){
            return true;
        }
        return false;
    }
    
    public int maxFreqSum(String s) {
        Map<Character,Integer> vowel = new HashMap<>();
        Map<Character,Integer> conso = new HashMap<>();


        for(char c:s.toCharArray()){
            if(isVowel(c)){
                vowel.put(c,vowel.getOrDefault(c,0)+1);
            }
            else{
                conso.put(c,conso.getOrDefault(c,0)+1);
            }
        }
        ArrayList<Map.Entry<Character,Integer>> vList = new ArrayList<>(vowel.entrySet());
        ArrayList<Map.Entry<Character,Integer>> cList = new ArrayList<>(conso.entrySet());
        Collections.sort(vList,(a,b)->{
            return Integer.compare(b.getValue(),a.getValue());
        });
        Collections.sort(cList,(a,b)->{
            return Integer.compare(b.getValue(),a.getValue());
        });
        int temp = 0;
        if(cList.size()!=0){
            temp+=cList.get(0).getValue();
        }
        if(vList.size()!=0){
            temp+=vList.get(0).getValue();
        }
        return temp;
    }
}