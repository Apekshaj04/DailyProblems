class Solution {

    public int solve(int num) {
        String temp = String.valueOf(num);
        int n = temp.length();

        int wave = 0;

        for (int i = 1; i < n - 1; i++) {
            int prev = temp.charAt(i - 1) - '0';
            int curr = temp.charAt(i) - '0';
            int next = temp.charAt(i + 1) - '0';

            if ((curr > prev && curr > next) ||
                (curr < prev && curr < next)) {
                wave++;
            }
        }

        return wave;
    }

    public int totalWaviness(int num1, int num2) {
        int total = 0;

        for (int i = num1; i <= num2; i++) {
            total += solve(i);
        }

        return total;
    }
}