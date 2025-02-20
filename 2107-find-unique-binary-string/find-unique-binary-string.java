import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public void recursiveCalls(StringBuilder sb, int index, int n, ArrayList<String> arr) {
        if (sb.length() == n) { 
            arr.add(sb.toString());
            return;
        }
        
        sb.append("0");
        recursiveCalls(sb, index + 1, n, arr);
        sb.deleteCharAt(sb.length() - 1);

        sb.append("1");
        recursiveCalls(sb, index + 1, n, arr);
        sb.deleteCharAt(sb.length() - 1);
    }

    public String findDifferentBinaryString(String[] nums) {
        ArrayList<String> arr = new ArrayList<>();
        int n = nums.length;
        
        recursiveCalls(new StringBuilder(), 0, n, arr);
        
        HashSet<String> never = new HashSet<>();
        for (String x : nums) {
            never.add(x);
        }
        
        for (String y : arr) {
            if (!never.contains(y)) {
                return y;
            }
        }
        
        return "";
    }
}
