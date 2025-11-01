class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, int[]> occurences = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (!occurences.containsKey(c)) {
                occurences.put(c, new int[]{i, i});
            } else {
                occurences.get(c)[1] = i;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int[] occ = occurences.get(c);
            int end = occ[1];

            for (int j = i; j <= end; j++) {
                char t = s.charAt(j);
                map.put(t, map.get(t) - 1);
                if (map.get(t) == 0) {
                    map.remove(t);
                }
                end = Math.max(end, occurences.get(t)[1]);
            }

            result.add(end - i + 1);
            i = end; 
        }

        return result;
    }
}
