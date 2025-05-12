class Solution {
    public int totalNumbers(int[] digits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = digits.length;

        for(int d : digits){
            map.put(d, map.getOrDefault(d, 0) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 100; i <= 999; i++){
            if (i % 2 != 0) continue;

            String x = String.valueOf(i);
            HashMap<Integer,Integer> temp = new HashMap<>();

            for(int j = 0; j < x.length(); j++){
                int y = x.charAt(j) - '0'; 
                temp.put(y, temp.getOrDefault(y, 0) + 1);
            }

            boolean valid = true;
            for(Map.Entry<Integer,Integer> entry : temp.entrySet()){
                int digit = entry.getKey();
                int count = entry.getValue();
                if(map.getOrDefault(digit, 0) < count){
                    valid = false;
                    break;
                }
            }

            if(valid){
                res.add(i);
            }
        }
        return res.size();
    }
}