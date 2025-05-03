class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int minTop = 0; 
        int minBottom = 0; 
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int top : tops) {
            map.put(top, map.getOrDefault(top, 0) + 1);
        }

        int cnt = 0;
        int tfreq = -1;
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > cnt) {
                cnt = m.getValue();
                tfreq = m.getKey();
            }
        }

        map.clear();
        cnt = 0;
        int bfreq = -1;
        for(int b:bottoms){
            map.put(b,map.getOrDefault(b,0)+1);
        }
          for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() > cnt) {
                cnt = m.getValue();
                bfreq = m.getKey();
            }
        }


        for (int i = 0; i < n; i++) {
            if (tops[i] != tfreq) {
                if (bottoms[i] == tfreq) { 
                    minTop++;
                } else {
                    minTop = Integer.MAX_VALUE;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (bottoms[i] != bfreq) { 
                if (tops[i] == bfreq) {
                    minBottom++;
                } else {
                    minBottom = Integer.MAX_VALUE;
                    break;
                }
            }
        }

        int result = Math.min(minTop, minBottom);
        return result == Integer.MAX_VALUE ? -1 : result; 
    }
}
