/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode temp  = head;
        while(temp!=null){
            res.add(temp.val);
            temp = temp.next;

        }   
        int n = res.size();
        int result = 0;
        int t  = 0 ;
        for(int i = 0;i<res.size();i++){
            result+=res.get(n-i-1)*Math.pow(2,t);
            t++;
        }
        return result;
    }
}