class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        ArrayList<String>  arr = new ArrayList<>();
        for(int i =0;i<n;i+=k){
            String y = s.substring(i,Math.min(i+k,n));
            if(y.length()<k){
                while(y.length()<k){
                    y = y+fill;
                }
            }
            arr.add(y);
        }   
        String[] res = new String[arr.size()];
        for(int i = 0;i<arr.size();i++){
            res[i] = arr.get(i);
        }
        return res;
    }
}