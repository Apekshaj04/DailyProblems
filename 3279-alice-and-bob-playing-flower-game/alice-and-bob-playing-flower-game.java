class Solution {
    public long flowerGame(int n, int m) {
        long oddN = (n % 2 == 0) ? (n / 2) : (n / 2 + 1);
        long evenN = n / 2;
        long oddM = (m % 2 == 0) ? (m / 2) : (m / 2 + 1);
        long evenM = m / 2;

        return oddN * evenM + evenN * oddM;
    }
}
