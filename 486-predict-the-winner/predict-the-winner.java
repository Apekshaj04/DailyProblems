class Solution {
    boolean findWinner(List<Integer> res, int p1, int p2, int turn) {
        if (res.isEmpty()) {
            return p1 >= p2; // Base case: game ends
        }

        // Options for the player: pick from start or end
        int pickStart = res.get(0);
        int pickEnd = res.get(res.size() - 1);

        // Create new lists for recursive calls
        List<Integer> startList = new ArrayList<>(res);
        startList.remove(0);
        List<Integer> endList = new ArrayList<>(res);
        endList.remove(endList.size() - 1);

        // Player 1 (turn == 0) tries to maximize their score
        if (turn == 0) {
            return findWinner(startList, p1 + pickStart, p2, 1) ||
                   findWinner(endList, p1 + pickEnd, p2, 1);
        } 
        // Player 2 (turn == 1) tries to minimize Player 1's chances
        else {
            return findWinner(startList, p1, p2 + pickStart, 0) &&
                   findWinner(endList, p1, p2 + pickEnd, 0);
        }
    }

    public boolean predictTheWinner(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
        }
        return findWinner(res, 0, 0, 0);
    }
}
