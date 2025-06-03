class Solution {
    public String removeDigit(String number, char digit) {
        String maxString = "";
        int n = number.length();

        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                String temp = number.substring(0, i) + number.substring(i + 1);
                if (temp.compareTo(maxString) > 0) {
                    maxString = temp;
                }
            }
        }

        return maxString;
    }
}
