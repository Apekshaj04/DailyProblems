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
    public ListNode swapPairs(ListNode head) {
        if(head==null|| head.next==null){
            return head;
        }

        ListNode t = head;
        ListNode temp1 = head.next;
        ListNode temp2 = head.next.next;
        t.next = temp2;
        temp1.next = t;
        head = temp1;

        while(t!=null){
            if(t.next==null || t.next.next==null){
                break;
            }
            temp1 = t.next;
            temp2 = t.next.next;
            ListNode x = temp2.next;
            temp2.next = temp1;
            temp1.next = x;
            t.next = temp2;
            t=t.next.next;
        }

        return head;

    }
}