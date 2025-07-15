class Solution {
    public boolean isAlpha(char c){

        if((c>='a' && c<='z') || (c>='A' && c<='Z')){
            return true;
        }
        return false;
    }   
    public boolean isNumber(char c){
        if(c>='0' && c<='9'){
            return true;
        }
        return false;
    }
    public boolean isVowel(char c){
        if((c=='a' || c=='e' || c=='i' || c=='o' || c=='u') || (c=='A' || c=='E' || c=='I' || c=='O' || c=='U')){
            return true;
        }
        return false;
    }
    public boolean isConso(char c){
        if((c!='a' && c!='e' && c!='i' && c!='o' && c!='u') && (c!='A' && c!='E' && c!='I' && c!='O' && c!='U')){
            return true;
        }
        return false;

    }
    public boolean isValid(String word) {
        if(word.length()<3){
            return false;
        }
        int conso = 0,vowel = 0;
        for(char c:word.toCharArray()){
            if(!isAlpha(c) && !isNumber(c)){
                return false;
            }
            if(isAlpha(c)){
                        if(isVowel(c)){
                vowel++;
            }
            if(isConso(c)){
                conso++;
            }
            }
        
        }
        System.out.println(vowel+" "+conso);
        if(vowel>=1 && conso>=1){
            return true;
        }
        return false;
    }
}