class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        int[] minChar = new int[n];
        minChar[n-1] = s.charAt(n-1);
        for(int i = n-2;i>=0;i--){
            minChar[i] = Math.min(s.charAt(i),minChar[i+1]);
        }
        StringBuilder t = new StringBuilder();
        StringBuilder p = new StringBuilder();
        for(int i = 0;i<n;i++){
            t.append(s.charAt(i));
            while(t.length()>0 && t.charAt(t.length()-1)<=minChar[Math.min(i+1,n-1)]){
                p.append(t.charAt(t.length()-1));
                t.deleteCharAt(t.length()-1);
            }

        }
        for(int i = t.length()-1;i>=0;i--){
            p.append(t.charAt(i));
        }
        return p.toString();

    }

}