import java.math.BigInteger;
import java.util.*;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (String s : nums) {
            pq.offer(new BigInteger(s));
        }
        
        BigInteger temp = BigInteger.ZERO;
        while (!pq.isEmpty() && k != 0) {
            temp = pq.poll();
            k--;
        }
        
        if (k > 0) {
            return "0";
        }
        
        return temp.toString();
    }
}
