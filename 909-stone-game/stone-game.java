import java.util.*;

class Solution {
    public boolean stoneGame(int[] piles) {
        Deque<Integer> d = new ArrayDeque<>();
        for (int pile : piles) {
            d.add(pile);
        }

        int index = 0;
        int alice = 0, bob = 0;

        while (!d.isEmpty()) {
            int pick;
            if(index%2==0){
                if(d.peekFirst()>=d.peekLast()){
                    alice+=d.removeFirst();

                }
                else{
                    alice+=d.removeLast();
                }
            }   
            else{
                if(d.peekFirst()>=d.peekLast()){
                    bob+=d.removeLast();
                }
                else{
                    alice+=d.removeFirst();
                }
            }
            index++;
        }

        return alice > bob;
    }
}
