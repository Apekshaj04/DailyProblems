class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length()<4 || s.length()>12) return result;
        backtrack(result,0,3,new StringBuilder(s));
        return result;
    }
        public void backtrack(List<String> result,int start,int k ,StringBuilder sb){
            if(k==0){
                String last = sb.substring(start);
                if(!last.isEmpty() && isValidSegment(last)){
                    result.add(sb.toString());

                }
                    return ;
            }
            for(int i = start;i<sb.length() && i-start<=2;i++){
                String substr  = sb.substring(start,i+1);
                if(!isValidSegment(substr)) continue;
                    StringBuilder next = new StringBuilder(sb);
                    next.insert(i+1,'.');
                    backtrack(result,i+2,k-1,next);
                    // sb.deleteCharAt(i+1);
                
            }
        }
        public boolean isValidSegment(String s){
            if(s.length()>1 && s.startsWith("0")) return false;
            int x = Integer.parseInt(s);
            return x>=0 && x<=255;
        }
}