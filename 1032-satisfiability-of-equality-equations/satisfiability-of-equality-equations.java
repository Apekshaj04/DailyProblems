class Solution {
    public boolean equationsPossible(String[] equations) {
        char[] parent = new char[26];
        for(int i =0;i<26;i++){
            parent[i] = (char)(i+'a');
        }
        for(String eqs:equations){
            char a = eqs.charAt(0);
            char c = eqs.charAt(1);
            char b = eqs.charAt(3);
            if(c=='='){
                char pa = findParent(a,parent);
                char pb = findParent(b,parent);
                if(pa==pb) continue;
                if(pa<pb){
                    parent[pb-'a'] = pa;
                }
                else{
                    parent[pa-'a'] = pb;
                }
            }
        }
        for(String eqs:equations){
            char a = eqs.charAt(0);
            char c = eqs.charAt(1);
            char b = eqs.charAt(3);
            if(c=='!'){
                char pa = findParent(a,parent);
                char pb = findParent(b,parent);
                if(pa==pb){
                    return false;
                }
            }
        }
        return true;

    }
    private char findParent(char a,char[] parent){
        if(a==parent[a-'a']) return a;
        return parent[a-'a'] = findParent(parent[a-'a'],parent);
    }
}