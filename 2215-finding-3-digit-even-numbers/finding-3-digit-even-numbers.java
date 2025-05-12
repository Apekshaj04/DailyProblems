class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = digits.length;

        // Count frequency of each digit in input
        for(int d : digits){
            map.put(d, map.getOrDefault(d, 0) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 100; i <= 999; i++){
            if (i % 2 != 0) continue; // Skip odd numbers

            String x = String.valueOf(i);
            HashMap<Integer,Integer> temp = new HashMap<>();

            // Count digits in number i
            for(int j = 0; j < x.length(); j++){
                int y = x.charAt(j) - '0'; // Correct way to get digit
                temp.put(y, temp.getOrDefault(y, 0) + 1);
            }

            // Compare if all digits of i exist in original digits[] with enough frequency
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

        // Convert ArrayList to sorted array
        Collections.sort(res);
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }

        return ans;
    }
}
