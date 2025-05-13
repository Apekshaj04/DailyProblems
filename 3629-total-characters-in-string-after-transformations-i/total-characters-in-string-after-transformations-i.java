import java.util.*;

class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1_000_000_007;
        long[] freq = new long[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        for(int i = 0;i<t;i++){
            long[] nextFreq = new long[26];
            for(int j = 0;j<26;j++){
                if(freq[j]==0) continue ; 
                if(j==25){
                    nextFreq[0] = (freq[j]+nextFreq[0])%MOD;
                    nextFreq[1] = (freq[j]+nextFreq[1])%MOD;
                }
                else{
                    nextFreq[j+1] = (freq[j]+nextFreq[j+1])%MOD;
                }
            }
            freq = nextFreq;
        }
        long total = 0;
        for(long cnt:freq){
            total = (total+cnt)%MOD;
        }
        return (int) total;
    }
}
