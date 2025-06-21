class Solution {
    public boolean equalFrequency(String word) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int freq : freqMap.values()) {
            countMap.put(freq, countMap.getOrDefault(freq, 0) + 1);
        }
        if (countMap.size() > 2) return false;

        if (countMap.size() == 1) {
            int key = countMap.keySet().iterator().next();
   
            return key == 1 || countMap.get(key) == 1;
        }

        ArrayList<Integer> keys = new ArrayList<>(countMap.keySet());
        int f1 = keys.get(0), f2 = keys.get(1);
        int c1 = countMap.get(f1), c2 = countMap.get(f2);

        if ((f1 == 1 && c1 == 1) || (f2 == 1 && c2 == 1)) return true;

        
        if (Math.abs(f1 - f2) == 1) {
            if ((f1 > f2 && c1 == 1) || (f2 > f1 && c2 == 1)) return true;
        }

        return false;
    }
}
