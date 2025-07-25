class Solution {
    public String maximumTime(String time) {
        char[] t = time.toCharArray();  // Convert to char array for in-place editing

        if (t[0] == '?') {
            t[0] = (t[1] == '?' || t[1] <= '3') ? '2' : '1';
        }

        if (t[1] == '?') {
            t[1] = (t[0] == '2') ? '3' : '9';
        }

        if (t[3] == '?') {
            t[3] = '5';
        }

        if (t[4] == '?') {
            t[4] = '9';
        }

        return new String(t);  // Convert back to string
    }
}
