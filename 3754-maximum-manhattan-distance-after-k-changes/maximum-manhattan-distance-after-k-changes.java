class Solution {
    public int maxDistance(String s, int k) {
        int n = s.length();
        int max = 0;
        for(char hor:"EW".toCharArray()){
            for(char ver:"NS".toCharArray()){
                int rem = k,netX = 0 ,netY = 0;
                for(char ch:s.toCharArray()){
                    if(ch==hor && rem>0){
                        ch = (ch=='W')?'E':'W';
                        rem--;
                    }
                    if(ch==ver && rem>0){
                        ch=(ch=='N')?'S':'N';
                        rem--;
                    }
                    netX+=(ch=='E')?1:0;
                    netX-=(ch=='W')?1:0;
                    netY+=(ch=='N')?1:0;
                    netY-=(ch=='S')?1:0;
                    max = Math.max(max,Math.abs(netX)+Math.abs(netY));
                }

            }
        }
        return max;
    }
}