from collections import defaultdict 
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        n = len(s)
        m = len(t)
        if n!=m: 
            return False
        map1 = defaultdict(int)
        map2 = defaultdict(int)
        for i in range(n):
            map1[s[i]]+=1
        for j in range(m):
            map2[t[j]]+=1
        return map1==map2
        