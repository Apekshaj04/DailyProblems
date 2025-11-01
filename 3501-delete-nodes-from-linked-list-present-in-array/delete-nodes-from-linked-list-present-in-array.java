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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if(head==null){
            return head;
        }
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        ListNode prev = head;
        while(prev!=null && set.contains(prev.val)){
            prev = prev.next;
        }
        ListNode result = prev;
        ListNode nextN = prev.next;
        while(nextN!=null){
            if(set.contains(nextN.val)){
                prev.next = nextN.next;
                // nextN = nextN.next;
            }
            else{
                prev = nextN;
            }
            nextN = nextN.next;
        }
        return result;

    }
}