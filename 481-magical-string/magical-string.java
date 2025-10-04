class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;

        StringBuilder sb = new StringBuilder();
        sb.append("122");

        for (int i = 2; sb.length() < n; i++) {
            int count = sb.charAt(i) - '0';
            char lastChar = sb.charAt(sb.length() - 1);
            char nextChar = (lastChar == '1') ? '2' : '1';

            for (int j = 0; j < count; j++) {
                sb.append(nextChar);
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == '1') cnt++;
        }

        return cnt;
    }
}
